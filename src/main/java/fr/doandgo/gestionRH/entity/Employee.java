package fr.doandgo.gestionRH.entity;

import fr.doandgo.gestionRH.enums.Diplome;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;
@EqualsAndHashCode()
@Entity
@Data
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private Date birthDay;
    private Diplome diplomeLevel;
    @OneToMany
    private List<Contract> contracts;
    @ManyToOne
    private Address address;

    public Employee() {

    }
}
