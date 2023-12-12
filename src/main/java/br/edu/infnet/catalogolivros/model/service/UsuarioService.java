package br.edu.infnet.catalogolivros.model.service;

import br.edu.infnet.catalogolivros.model.domain.Usuario;
import br.edu.infnet.catalogolivros.model.repositories.UsuarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRespository usuarioRespository;
	public void incluir(Usuario usuario) {
		usuarioRespository.save(usuario);
	}
	public Collection<Usuario> obterListaLivros() {
		return (Collection<Usuario>) usuarioRespository.findAll();
	}
}
