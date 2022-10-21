package com.starking.msvalidadorcredito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starking.msvalidadorcredito.domain.DadosAvaliacao;
import com.starking.msvalidadorcredito.domain.DadosSolicitacaoEmissaoCartao;
import com.starking.msvalidadorcredito.domain.ProtocoloSolicitacaoCartao;
import com.starking.msvalidadorcredito.domain.RetornoAvaliacaoCliente;
import com.starking.msvalidadorcredito.domain.SituacaoCliente;
import com.starking.msvalidadorcredito.exception.DadosClienteNotFoundException;
import com.starking.msvalidadorcredito.exception.ErroComunicacaoMicroServicesException;
import com.starking.msvalidadorcredito.exception.ErroSolicitacaoCartaoException;
import com.starking.msvalidadorcredito.services.AvaliadorCreditoService;

@RestController
@RequestMapping("avaliacoes-credito")
public class AvaliadorCreditoController {

	@Autowired
    private AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @GetMapping(value = "situacao-cliente", params = "cpf")
    public ResponseEntity<?> consultarSituacaoCliente(@RequestParam("cpf") String cpf){
        try {
            SituacaoCliente situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
            return ResponseEntity.ok(situacaoCliente);
        } catch (DadosClienteNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ErroComunicacaoMicroServicesException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }
    
    @PostMapping
    public ResponseEntity<?> realizarAvaliacao(@RequestBody DadosAvaliacao dados) {
    	 try {
            RetornoAvaliacaoCliente retornoAvaliacaoCliente = this.avaliadorCreditoService.realizarAvaliacao(dados.getCpf(), dados.getRenda());
            return ResponseEntity.ok(retornoAvaliacaoCliente);
         } catch (DadosClienteNotFoundException e) {
             return ResponseEntity.notFound().build();
         } catch (ErroComunicacaoMicroServicesException e) {
             return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
         }
    }
    
    @PostMapping("solicitacoes-cartao")
    public ResponseEntity<?> solicitarCartao(@RequestBody DadosSolicitacaoEmissaoCartao dados) {
    	try {
    		ProtocoloSolicitacaoCartao protocoloSolicitacaoCartao = this.avaliadorCreditoService.solicitarEmissaoCartao(dados);
    		return ResponseEntity.ok(protocoloSolicitacaoCartao);
    	} catch(ErroSolicitacaoCartaoException e) {
    		return ResponseEntity.internalServerError().body(e.getMessage());
    	}
    }
}
