package br.edu.infnet.catalogolivros.model.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ip;
	private String senha;
	final private LocalDateTime DATA_CRICAO;
	public Admin() {
		this.DATA_CRICAO = LocalDateTime.now();
	}
	public Admin(Integer id) {
		this.id = id;
		this.DATA_CRICAO = LocalDateTime.now();
	}
	public Admin(String ip, String senha) {
		this.ip = ip;
		this.senha = senha;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public LocalDateTime getDataCriacao() {
		return DATA_CRICAO;
	}
	public String toString() {
		return String.format("IP: %s, Senha: %s, Admin desde: %s", getIp(), getSenha(), getDataCriacao().format(DateTimeFormatter.ISO_LOCAL_DATE));
		// , Livro Criados: %s getListaLivrosCriados()
	}
}
