package br.edu.infnet.catalogolivros.model.service;

import br.edu.infnet.catalogolivros.model.domain.Livro;
import br.edu.infnet.catalogolivros.model.repositories.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	public void incluir(Livro livro) {
		livroRepository.save(livro);
	}

	public Collection<Livro> obterListaLivros() {
		return (Collection<Livro>) livroRepository.findAll();
	}

	public void excluir(Integer id) {
		livroRepository.deleteById(id);
	}
}
