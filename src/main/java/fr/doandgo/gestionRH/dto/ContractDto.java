package fr.doandgo.gestionRH.dto;

import fr.doandgo.gestionRH.entity.Employee;
import fr.doandgo.gestionRH.entity.Job;
import fr.doandgo.gestionRH.enums.ContractTypes;
import fr.doandgo.gestionRH.enums.TerminationReason;
import fr.doandgo.gestionRH.enums.WorkingCondition;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class ContractDto {
    private Integer id;
    private ContractTypes contractTypes;
    private Date startDate;
    private Date endDate;
    private Double salary;
    private TerminationReason terminationReason;
    private WorkingCondition workingCondition;
    private Integer employeeId;
    private Integer jobId;

    public ContractDto(){}

    public ContractDto(Integer id, ContractTypes contractTypes, Date startDate, Date endDate, Double salary, TerminationReason terminationReason, WorkingCondition workingCondition, Employee employee, Job job) {
        this.id = id;
        this.contractTypes = contractTypes;
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.terminationReason = terminationReason;
        this.workingCondition = workingCondition;
        this.employeeId = employee.getId();
        this.jobId = job.getId();
    }
}
