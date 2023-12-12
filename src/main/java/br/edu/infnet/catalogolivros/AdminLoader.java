package br.edu.infnet.catalogolivros;

import br.edu.infnet.catalogolivros.model.domain.Admin;
import br.edu.infnet.catalogolivros.model.domain.Livro;
import br.edu.infnet.catalogolivros.model.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

@Order(1)
@Component
public class AdminLoader implements ApplicationRunner {
	@Autowired
	private AdminService adminService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader arquivo = new FileReader("arquivos/admins.txt");
		BufferedReader leituraArquivo = new BufferedReader(arquivo);
		String linha = leituraArquivo.readLine();
		String[] adminDados;
		while (linha != null) {
			adminDados = linha.split(";");
			System.out.println("[LINHA] " + linha);
			Admin admin = new Admin();
			admin.setIp(adminDados[0]);
			admin.setSenha(adminDados[1]);
			admin.setListaLivrosCriados(new ArrayList<Livro>());
			adminService.incluir(admin);
			linha = leituraArquivo.readLine();
		}
		for (Admin admin : adminService.obterListaAdmins()) {
			System.out.println("[ADMIN] " + admin);
		}
		leituraArquivo.close();
	}
}
