package br.edu.infnet.catalogolivros.model.repositories;

import br.edu.infnet.catalogolivros.model.domain.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, String> {

}
