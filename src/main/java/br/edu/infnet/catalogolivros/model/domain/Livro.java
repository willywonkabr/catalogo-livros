package br.edu.infnet.catalogolivros.model.domain;

public class Livro {
        private String titulo;
        private String autor;
        private String isbn;
        private String sinopse;

        public Livro(String titulo, String autor, String isbn, String sinopse) {
                this.titulo = titulo;
                this.autor = autor;
                this.isbn = isbn;
                this.sinopse = sinopse;
        }

        public Livro() {}

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

        public String toString() {
                return String.format("Título: %s Autor: %s, ISBN: %s, Sinopse: %s", getTitulo(), getAutor(), getIsbn(), getSinopse());
        }
}
