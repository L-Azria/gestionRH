package fr.doandgo.gestionRH.entity;

import fr.doandgo.gestionRH.dto.ContractDto;
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
    private Date startDate;
    private Date endDate;
    private Double salary;
    private TerminationReason terminationReason;
    private WorkingCondition workingCondition;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Job job;



    public Contract() {

    }

    public ContractDto toContractDto(Contract contract){
        return new ContractDto(
                contract.getId(),
                contract.getContractTypes(),
                contract.getStartDate(),
                contract.getEndDate(),
                contract.getSalary(),
                contract.getTerminationReason(),
                contract.getWorkingCondition(),
                contract.getEmployee(),
                contract.getJob()
        );
    }
}
