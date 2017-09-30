package br.com.scchp.sistemasocio.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by milene on 26/09/17.
 */
@Data
@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private Date birthdayDate;
    private Date registerDate;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "member")
    private List<Dependent> dependent;
}
