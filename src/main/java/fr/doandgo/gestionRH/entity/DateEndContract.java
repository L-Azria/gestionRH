package fr.doandgo.gestionRH.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode()
@Entity
@Data
@AllArgsConstructor
public class DateEndContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateEnd;



    public DateEndContract() {

    }
}
