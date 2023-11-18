package br.edu.infnet.catalogolivros.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Admin {
	private String ip;
	private String senha;
	private List<Livro> listaLivrosCriados;
	final private LocalDateTime DATA_CRICAO;

	public Admin() {
		this.DATA_CRICAO = LocalDateTime.now();
	}

	public Admin(String ip, String senha, List<Livro> listaLivrosCriados) {
		this.ip = ip;
		this.senha = senha;
		this.listaLivrosCriados = listaLivrosCriados;
		this.DATA_CRICAO = LocalDateTime.now();
	}

	public void criarLivro() {
	}

	public void editarLivro() {
	}

	public void deletarLivro() {
	}

	public void mudarTemaPagina() {
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Livro> getListaLivrosCriados() {
		return listaLivrosCriados;
	}

	public void setListaLivrosCriados(List<Livro> listaLivrosCriados) {
		this.listaLivrosCriados = listaLivrosCriados;
	}

	public LocalDateTime getDataCriacao() {
		return DATA_CRICAO;
	}

	public String toString() {
		return String.format("IP: %s, Senha: %s, Admin desde: %s", getIp(), getSenha(), getDataCriacao().format(DateTimeFormatter.ISO_LOCAL_DATE));
	}
}
