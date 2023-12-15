package br.edu.infnet.catalogolivros;

import br.edu.infnet.catalogolivros.model.domain.Admin;
import br.edu.infnet.catalogolivros.model.domain.Livro;
import br.edu.infnet.catalogolivros.model.domain.Usuario;
import br.edu.infnet.catalogolivros.model.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

@Order(2)
@Component
public class LivroLoader implements ApplicationRunner {
	@Autowired
	private LivroService livroService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader arquivo = new FileReader("arquivos/livros.txt");
		BufferedReader leituraArquivo = new BufferedReader(arquivo);
		String linha = leituraArquivo.readLine();
		String[] livroDados;
		while (linha != null) {
			livroDados = linha.split(";");
			System.out.println("[LINHA] " + linha);
			Livro livro = new Livro();
			livro.setTitulo(livroDados[1]);
			livro.setAutor(livroDados[2]);
			livro.setIsbn(livroDados[3]);
			livro.setSinopse(livroDados[4]);
			livro.setAdmin(new Admin(Integer.valueOf(livroDados[5])));
			livro.setListaUsuariosFavoritaram(new ArrayList<Usuario>());
			livroService.incluir(livro);
			linha = leituraArquivo.readLine();
		}
		for (Livro livro : livroService.obterListaLivros()) {
			System.out.println("[LIVRO] " + livro);
		}
		leituraArquivo.close();
	}
}
