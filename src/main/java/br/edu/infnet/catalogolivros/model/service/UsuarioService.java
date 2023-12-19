package br.edu.infnet.catalogolivros.model.service;

import br.edu.infnet.catalogolivros.model.domain.Endereco;
import br.edu.infnet.catalogolivros.model.domain.Usuario;
import br.edu.infnet.catalogolivros.model.repositories.UsuarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRespository usuarioRespository;
	@Autowired
	private EnderecoService enderecoService;
	public void incluir(Usuario usuario) {
		String cep = usuario.getEndereco().getCep();
		Endereco endereco = enderecoService.buscarCep(cep);
		usuario.setEndereco(endereco);
		usuarioRespository.save(usuario);
	}
	public Collection<Usuario> obterListaUsuarios() {
		return (Collection<Usuario>) usuarioRespository.findAll();
	}
	public void excluir(Integer id) {
		usuarioRespository.deleteById(id);
	}
}
