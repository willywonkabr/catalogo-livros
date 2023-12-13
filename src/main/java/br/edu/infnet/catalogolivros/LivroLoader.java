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
			livro.setTitulo(livroDados[0]);
			livro.setAutor(livroDados[1]);
			livro.setIsbn(livroDados[2]);
			livro.setSinopse(livroDados[3]);
			livro.setAdmin(new Admin(livroDados[4]));
			livro.getAdmin().setListaLivrosCriados(new ArrayList<>());
			livro.getAdmin().getListaLivrosCriados().add(new Livro(livroDados[0]));
			livro.setListaUsuariosFavoritaram(new ArrayList<>());
			livro.getListaUsuariosFavoritaram().add(new Usuario(livroDados[5]));
			livroService.incluir(livro);
			linha = leituraArquivo.readLine();
		}
		for (Livro livro : livroService.obterListaLivros()) {
			System.out.println("[LIVRO] " + livro);
		}
		leituraArquivo.close();
	}
}
