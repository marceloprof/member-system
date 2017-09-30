package br.com.scchp.sistemasocio.entities;

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
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
