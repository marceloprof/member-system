package br.com.scchp.sistemasocio.repositories;

import br.com.scchp.sistemasocio.entities.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by milene on 27/09/17.
 */
@Repository
public interface MemberRepository extends CrudRepository<Member, Long>{
    List<Member> findAllByName(String name);
}
