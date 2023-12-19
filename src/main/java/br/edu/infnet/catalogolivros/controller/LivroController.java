package br.edu.infnet.catalogolivros.controller;

import br.edu.infnet.catalogolivros.model.domain.Livro;
import br.edu.infnet.catalogolivros.model.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/livro/")
public class LivroController {
	@Autowired
	private LivroService livroService;
	@GetMapping(value = "listar")
	public List<Livro> obterListaLivros() {
		return (List<Livro>) livroService.obterListaLivros();
	}
	@PostMapping(value = "incluir")
	public void incluirLivro(@RequestBody Livro livro) {
		livroService.incluir(livro);
	}
	@DeleteMapping(value = "{id}/excluir")
	public void excluirLivro(@PathVariable Integer id) {
		livroService.excluir(id);
	}
}
