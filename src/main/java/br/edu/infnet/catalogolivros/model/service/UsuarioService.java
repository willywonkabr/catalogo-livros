package br.edu.infnet.catalogolivros.model.service;

import br.edu.infnet.catalogolivros.model.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioService {
	private  final Map<String, Usuario> mapa = new HashMap<>();
	public void incluir(Usuario usuario) {
		mapa.put(usuario.getNome(), usuario);
	}
	public Collection<Usuario> obterListaLivros() {
		return mapa.values();
	}
}
