package br.edu.infnet.catalogolivros.model.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Livro {
	@Id
	private String titulo;
	private String autor;
	private String isbn;
	private String sinopse;
	@Transient
	private Admin admin;
	public Livro() {
	}
	public Livro(String titulo, String autor, String isbn, String sinopse, Admin admin) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.sinopse = sinopse;
		this.admin = admin;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String toString() {
		return String.format("Título: %s, Autor: %s, ISBN: %s, Sinopse: %s, Criado por: [ADMIN] %s", getTitulo(), getAutor(), getIsbn(), getSinopse(), getAdmin());
	}
}
