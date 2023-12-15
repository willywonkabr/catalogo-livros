package br.edu.infnet.catalogolivros.model.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private int idade;
	@ManyToMany(mappedBy = "listaUsuariosFavoritaram")
	private List<Livro> listaLivrosFavoritos;
	public void mudarTemaPagina() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public List<Livro> getListaLivrosFavoritos() {
		return listaLivrosFavoritos;
	}
	public void setListaLivrosFavoritos(List<Livro> listaLivrosFavoritos) {
		this.listaLivrosFavoritos = listaLivrosFavoritos;
	}
	public String toString() {
		return String.format("Nome: %s, Idade: %d, Livros Favoritos: %s", getNome(), getIdade(), getListaLivrosFavoritos());
	}
}
