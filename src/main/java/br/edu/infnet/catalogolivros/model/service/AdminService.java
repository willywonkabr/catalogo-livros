package br.edu.infnet.catalogolivros.model.service;

import br.edu.infnet.catalogolivros.model.domain.Admin;
import br.edu.infnet.catalogolivros.model.repositories.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	public void incluir(Admin admin) {
		adminRepository.save(admin);
	}
	public Collection<Admin> obterListaAdmins() {
		return (Collection<Admin>) adminRepository.findAll();
	}
	public void excluir(Integer id) {
		adminRepository.deleteById(id);
	}
}
