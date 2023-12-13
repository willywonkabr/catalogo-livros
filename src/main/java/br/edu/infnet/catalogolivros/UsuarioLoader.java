package br.edu.infnet.catalogolivros;

import br.edu.infnet.catalogolivros.model.domain.Livro;
import br.edu.infnet.catalogolivros.model.domain.Usuario;
import br.edu.infnet.catalogolivros.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

@Order(3)
@Component
public class UsuarioLoader implements ApplicationRunner {
	@Autowired
	private UsuarioService usuarioService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader arquivo = new FileReader("arquivos/usuarios.txt");
		BufferedReader leituraArquivo = new BufferedReader(arquivo);
		String linha = leituraArquivo.readLine();
		String[] usuarioDados;
		while (linha != null) {
			usuarioDados = linha.split(";");
			System.out.println("[LINHA] " + linha);
			Usuario usuario = new Usuario();
			usuario.setNome(usuarioDados[0]);
			usuario.setIdade(Integer.valueOf(usuarioDados[1]));
			usuario.setListaLivrosFavoritos(new ArrayList<>());
			usuario.getListaLivrosFavoritos().add(new Livro(usuarioDados[2]));
			usuarioService.incluir(usuario);
			linha = leituraArquivo.readLine();
		}
		for (Usuario usuario : usuarioService.obterListaUsuarios()) {
			System.out.println("[USUARIO] " + usuario);
		}
		leituraArquivo.close();
	}
}
