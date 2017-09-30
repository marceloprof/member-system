package br.com.scchp.sistemasocio.repositories;

import br.com.scchp.sistemasocio.entities.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milene on 27/09/17.
 */
@Repository
public interface MemberRepository extends CrudRepository<Member, Long>{
    public String findByName(String name);
}
