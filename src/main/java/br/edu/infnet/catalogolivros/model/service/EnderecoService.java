package br.edu.infnet.catalogolivros.model.service;

import br.edu.infnet.catalogolivros.clients.IEnderecoClient;
import br.edu.infnet.catalogolivros.model.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
	@Autowired
	private IEnderecoClient enderecoClient;
	public Endereco buscarCep(String cep) {
		return enderecoClient.buscarCep(cep);
	}
}
