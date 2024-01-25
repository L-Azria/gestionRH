package fr.doandgo.gestionRH.service;

import fr.doandgo.gestionRH.dto.ContractDto;
import fr.doandgo.gestionRH.dto.EmployeeDto;
import fr.doandgo.gestionRH.entity.Contract;
import fr.doandgo.gestionRH.entity.Job;
import fr.doandgo.gestionRH.repository.CompagnyRepository;
import fr.doandgo.gestionRH.repository.ContractRepository;
import fr.doandgo.gestionRH.repository.EmployeeRepository;
import fr.doandgo.gestionRH.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ContractService {
    private ContractRepository contractRepository;
    private JobRepository jobRepository;
    private EmployeeRepository employeeRepository;
    private CompagnyRepository compagnyRepository;

    public List<ContractDto> findContractByEmployee(EmployeeDto selectedEmployeeId){
        List<Contract> contracts = contractRepository.findContractsByEmployee_Id(selectedEmployeeId.getId());
        List<ContractDto> contractDtoList = new ArrayList<>();
        if (!contracts.isEmpty()) {
            for (Contract c : contracts) {
                contractDtoList.add(c.toContractDto(c));
            }
        } else {
            System.out.println("La personne n'a pas de contrat");
        }
        return contractDtoList;

    }

    public void createContract(ContractDto dto){
        Contract newContract = new Contract();
        newContract.setContractTypes(dto.getContractTypes());
        newContract.setStartDate(dto.getStartDate());
        newContract.setEndDate(dto.getEndDate());
        newContract.setSalary(dto.getSalary());
        newContract.setTerminationReason(dto.getTerminationReason());
        newContract.setWorkingCondition(dto.getWorkingCondition());
        newContract.setJob(jobRepository.findById(dto.getJobId()).orElseThrow());
        newContract.setEmployee(employeeRepository.findById(dto.getEmployeeId()).orElseThrow());

        contractRepository.save(newContract);

    }

}
