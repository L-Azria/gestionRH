package fr.doandgo.gestionRH.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode()
@Entity
@Data
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer codePostal;
    private String nameCity;

    public City() {

    }


    public City(Integer codePostal, String nameCity) {

    }
}
