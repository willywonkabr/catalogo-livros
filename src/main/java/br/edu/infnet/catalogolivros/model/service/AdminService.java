package br.edu.infnet.catalogolivros.model.service;

import br.edu.infnet.catalogolivros.model.domain.Admin;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdminService {
	private final Map<String, Admin> mapa = new HashMap<>();
	public void incluir(Admin admin) {
		mapa.put(admin.getIp(), admin);
	}
	public Collection<Admin> obterListaAdmins() {
		return mapa.values();
	}
}
