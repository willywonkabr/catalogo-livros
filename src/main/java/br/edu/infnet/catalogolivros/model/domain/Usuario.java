package br.edu.infnet.catalogolivros.model.domain;

import java.util.List;

public class Usuario {

        private String nome;

        private int idade;

        private List<Livro> listaLivrosFavoritos;

        public void mudarTemaPagina() {}

        public Usuario(String nome, int idade) {
                this.nome = nome;
                this.idade = idade;
        }

        public Usuario() {}

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
                return String.format("Nome: %s  Idade: %d", getNome(), getIdade());
        }
}
