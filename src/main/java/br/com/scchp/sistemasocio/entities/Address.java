package br.com.scchp.sistemasocio.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by milene on 26/09/17.
 */
@Data
@Entity
public class Address {

    @Id @GeneratedValue
    private Long id;
    private String street;
    private Integer number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
}
