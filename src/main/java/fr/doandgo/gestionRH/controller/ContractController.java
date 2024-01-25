package fr.doandgo.gestionRH.controller;

import fr.doandgo.gestionRH.dto.ContractDto;
import fr.doandgo.gestionRH.dto.EmployeeDto;
import fr.doandgo.gestionRH.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
@AllArgsConstructor
public class ContractController extends AbstractController<ContractDto> {
    private ContractService contractService;
    @Override
    public ContractDto getDtoById(Integer id) {
        return null;
    }

    @Override
    public List<ContractDto> getAllDto() {
        return null;
    }

    public List<ContractDto> getContractDtoByEmployee(EmployeeDto selectedEmployeeId){
        return this.contractService.findContractByEmployee(selectedEmployeeId);
    }

    @Override
    public void createDto(ContractDto dto) {
        this.contractService.createContract(dto);

    }

    @Override
    public void updateDto(Integer id, ContractDto dto) {

    }

    @Override
    public void deleteDto(Integer id) {

    }


}
