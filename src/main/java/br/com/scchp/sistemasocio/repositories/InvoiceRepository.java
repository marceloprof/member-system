package br.com.scchp.sistemasocio.repositories;

import br.com.scchp.sistemasocio.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Date;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

    @Query("SELECT i FROM Invoice i WHERE i.member.id = ?1 AND i.paymentDate is not null order by i.dueDate")
    Invoice findOneByMemberId(Long memberId);

    @Query("SELECT i FROM Invoice i WHERE i.member.id = ?1 AND i.paymentDate is not null AND i.dueDate = ?2")
    Invoice findOneByMemberAndDueDate(Long memberId, Date dueDate);
}
