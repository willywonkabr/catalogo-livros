package br.edu.infnet.catalogolivros.model.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Livro {
	@Id
	private String titulo;
	private String autor;
	private String isbn;
	private String sinopse;
	@ManyToOne
	@JoinColumn(name = "idLivro")
	private Admin admin;
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	private List<Usuario> listaUsuariosFavoritaram;
	public Livro() {
	}
	public Livro(String titulo) {
		this.titulo = titulo;
	}
	public Livro(String titulo, String autor, String isbn, String sinopse, Admin admin, List<Usuario> listaUsuariosFavoritaram) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.sinopse = sinopse;
		this.admin = admin;
		this.listaUsuariosFavoritaram = listaUsuariosFavoritaram;
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
	public List<Usuario> getListaUsuariosFavoritaram() {
		return listaUsuariosFavoritaram;
	}
	public void setListaUsuariosFavoritaram(List<Usuario> listaUsuariosFavoritaram) {
		this.listaUsuariosFavoritaram = listaUsuariosFavoritaram;
	}
	public String toString() {
		return String.format("Título: %s, Autor: %s, ISBN: %s, Sinopse: %s, Criado por: [ADMIN] %s", getTitulo(), getAutor(), getIsbn(), getSinopse(), getAdmin());
		//, Usuário que favoritaram: %s", getListaUsuariosFavoritaram());
	}
}
