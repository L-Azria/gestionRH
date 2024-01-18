package fr.doandgo.gestionRH.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode()
@Entity
@Data
@AllArgsConstructor
public class Amendment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Contract contract;

    public Amendment() {

    }
}
