package fr.doandgo.gestionRH.controller;


import fr.doandgo.gestionRH.dto.EmployeeDto;
import fr.doandgo.gestionRH.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
@Component
@RestController
@AllArgsConstructor
public class EmployeeController extends AbstractController<EmployeeDto> {
    private EmployeeService employeeService;

    @Override
    public EmployeeDto getDtoById(Integer id) {
        return null;
    }

    @Override
    public List<EmployeeDto> getAllDto() {
        return this.employeeService.findAllEmployee();
    }

    @Override
    public void createDto(EmployeeDto dto) {
        this.employeeService.createEmployee(dto);
    }

    public EmployeeDto createEmployeeDto(EmployeeDto dto){
        return this.employeeService.createEmployee(dto);
    }

    @Override
    public void updateDto(Integer id, EmployeeDto dto) {

    }

    @Override
    public void deleteDto(Integer id) {

    }
}
