package br.edu.infnet.catalogolivros.model.repositories;

import br.edu.infnet.catalogolivros.model.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRespository extends CrudRepository<Usuario, String> {}
