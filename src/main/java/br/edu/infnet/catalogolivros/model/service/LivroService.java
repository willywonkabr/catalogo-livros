package br.edu.infnet.catalogolivros.model.service;

import br.edu.infnet.catalogolivros.model.domain.Livro;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class LivroService {
	private final Map<String, Livro> mapa = new HashMap<>();
	public void incluir(Livro livro) {
		mapa.put(livro.getIsbn(), livro);
	}
	public Collection<Livro> obterListaLivros() {
		return mapa.values();
	}
}
