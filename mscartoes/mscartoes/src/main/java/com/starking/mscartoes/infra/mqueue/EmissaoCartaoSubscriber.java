package com.starking.mscartoes.infra.mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starking.mscartoes.domain.Cartao;
import com.starking.mscartoes.domain.ClienteCartao;
import com.starking.mscartoes.domain.DadosSolicitacaoEmissaoCartao;
import com.starking.mscartoes.repository.CartaoRespository;
import com.starking.mscartoes.repository.ClienteCartaoRepository;

@Component
public class EmissaoCartaoSubscriber {
	
	@Autowired
	private CartaoRespository cartaoRespository;
	
	@Autowired
	private ClienteCartaoRepository clienteCartaoRepository;
	
	@RabbitListener(queues = "${mq.queues.emissao-cartoes}")
	public void receberSolicitacaoEmissao(@Payload String payload) {
		try {
			var mapper = new ObjectMapper();
			DadosSolicitacaoEmissaoCartao dados = mapper.readValue(payload, DadosSolicitacaoEmissaoCartao.class);
			Cartao cartao = this.cartaoRespository.findById(dados.getIdCartao()).orElseThrow();
			ClienteCartao clienteCartao = new ClienteCartao();
			clienteCartao.setCartao(cartao);
			clienteCartao.setCpf(dados.getCpf());
			clienteCartao.setLimite(dados.getLimiteLiberado());
			
			this.clienteCartaoRepository.save(clienteCartao);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
