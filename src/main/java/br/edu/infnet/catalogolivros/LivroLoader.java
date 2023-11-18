package br.edu.infnet.catalogolivros;

import br.edu.infnet.catalogolivros.model.domain.Admin;
import br.edu.infnet.catalogolivros.model.domain.Livro;
import br.edu.infnet.catalogolivros.model.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

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
			livro.setAdmin(new Admin());
			livro.getAdmin().setIp(livroDados[4]);
			livro.getAdmin().setSenha(livroDados[5]);
			livro.getAdmin().setListaLivrosCriados(new ArrayList<Livro>());
			livro.getAdmin().getListaLivrosCriados().add(livro);

			livroService.incluir(livro);

			linha = leituraArquivo.readLine();
		}

		for (Livro livro : livroService.obterListaLivros()) {
			System.out.println("[LIVRO] " + livro);
		}

		leituraArquivo.close();
	}
}
