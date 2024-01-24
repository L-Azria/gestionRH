package fr.doandgo.gestionRH.entity;

import fr.doandgo.gestionRH.enums.ContractTypes;
import fr.doandgo.gestionRH.enums.TerminationReason;
import fr.doandgo.gestionRH.enums.WorkingCondition;
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
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private ContractTypes contractTypes;
    @ManyToOne
    private DateStartContract startDate;
    @ManyToOne
    private DateEndContract endDate;
    private Double salary;
    private TerminationReason terminationReason;
    private WorkingCondition workingCondition;
    private String urlDoc;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Job job;
    @OneToMany
    private List<Amendment> amendments;


    public Contract() {

    }
}
