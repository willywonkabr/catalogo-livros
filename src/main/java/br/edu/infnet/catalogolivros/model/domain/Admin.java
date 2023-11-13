package br.edu.infnet.catalogolivros.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Admin {
        private String ip;
        private String senha;
        final private LocalDateTime DATA_CRICAO;

        public void criarLivro() {}
        public void editarLivro() {}
        public void deletarLivro() {}
        public void mudarTemaPagina() {}

        public Admin(String ip, String senha) {
                this.ip = ip;
                this.senha = senha;
                this.DATA_CRICAO = LocalDateTime.now();
        }

        public Admin() {
                this.DATA_CRICAO = LocalDateTime.now();
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

        public LocalDateTime getDataCriacao() { return DATA_CRICAO; }

        public String toString() {
                return String.format("IP: %s Senha: %s, Data de criação: %s", getIp(), getSenha(), getDataCriacao().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
}
