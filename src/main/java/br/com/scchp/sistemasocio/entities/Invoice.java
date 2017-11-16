package br.com.scchp.sistemasocio.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Invoice {

    @Id @GeneratedValue
    private Long id;
    private Date dueDate;
    private Date paymentDate;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "member_id")
    @JsonBackReference
    private Member member;
    private Double value;

}
