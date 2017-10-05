package br.com.scchp.sistemasocio.repositories;

import br.com.scchp.sistemasocio.entities.Dependent;
import br.com.scchp.sistemasocio.entities.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by milene on 27/09/17.
 */
@Repository
public interface DependentRepository extends CrudRepository<Dependent, Long>{
    List<Dependent> findAllByName(String name);
}
