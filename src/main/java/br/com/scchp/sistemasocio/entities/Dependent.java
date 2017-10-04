package br.com.scchp.sistemasocio.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by milene on 26/09/17.
 */
@Data
@Entity
public class Dependent {

    @Id @GeneratedValue
    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "member_id")
    @JsonBackReference
    private Member member;

}
