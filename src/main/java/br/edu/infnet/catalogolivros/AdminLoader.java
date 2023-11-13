package br.edu.infnet.catalogolivros;

import br.edu.infnet.catalogolivros.model.domain.Admin;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class AdminLoader implements ApplicationRunner  {

        private final Map<String, Admin> mapa = new HashMap<>();

        @Override
        public void run(ApplicationArguments args) throws Exception {
                FileReader arquivo = new FileReader("arquivos/admins.txt");
                BufferedReader leituraArquivo = new BufferedReader(arquivo);

                String linha = leituraArquivo.readLine();

                String[] adminDados;

                while(linha != null) {
                        adminDados = linha.split(";");
                        System.out.println("[LINHA] " + linha);

                        Admin admin = new Admin(adminDados[0], adminDados[1]);

                        mapa.put(admin.getIp(), admin);

                        linha = leituraArquivo.readLine();
                }

                for (Admin admin: mapa.values() ) {
                        System.out.println("[ADMIN] " + admin);
                }


                leituraArquivo.close();
        }
}
