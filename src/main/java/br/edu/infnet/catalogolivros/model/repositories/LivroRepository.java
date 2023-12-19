package br.edu.infnet.catalogolivros.model.repositories;

import br.edu.infnet.catalogolivros.model.domain.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Integer> {}
