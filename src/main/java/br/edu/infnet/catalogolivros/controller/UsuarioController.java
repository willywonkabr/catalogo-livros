package br.edu.infnet.catalogolivros.controller;

import br.edu.infnet.catalogolivros.model.domain.Usuario;
import br.edu.infnet.catalogolivros.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario/")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	@GetMapping(value = "listar")
	public List<Usuario> obterListaUsuarios() {
		return (List<Usuario>) usuarioService.obterListaUsuarios();
	}
	@PostMapping(value = "incluir")
	public void incluirUsuario(@RequestBody Usuario usuario) {
		usuarioService.incluir(usuario);
	}
	@DeleteMapping(value = "{id}/excluir")
	public void excluirUsuario(@PathVariable Integer id) {
		usuarioService.excluir(id);
	}
}
