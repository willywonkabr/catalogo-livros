package br.edu.infnet.catalogolivros.controller;

import br.edu.infnet.catalogolivros.model.domain.Admin;
import br.edu.infnet.catalogolivros.model.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@GetMapping(value = "listar")
	public List<Admin> obterListaAdmins() {
		return (List<Admin>) adminService.obterListaAdmins();
	}
	@PostMapping(value = "incluir")
	public void incluirAdmin(@RequestBody Admin admin) {
		adminService.incluir(admin);
	}
	@DeleteMapping(value = "{id}/excluir")
	public void excluirAdmin(@PathVariable Integer id) {
		adminService.excluir(id);
	}
}
