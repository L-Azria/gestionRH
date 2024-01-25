package fr.doandgo.gestionRH.service;

import fr.doandgo.gestionRH.dto.EmployeeDto;
import fr.doandgo.gestionRH.entity.Employee;
import fr.doandgo.gestionRH.repository.AddressRepository;
import fr.doandgo.gestionRH.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private AddressRepository addressRepository;

    public List<EmployeeDto> findAllEmployee(){
        List<Employee> employees = this.employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for(Employee e : employees){
            employeeDtoList.add(changeToEmployeeDto(e));
        }
        return employeeDtoList;
    }

    public EmployeeDto createEmployee(EmployeeDto emplyeeDto){
        Employee newEmployee = new Employee();
        newEmployee.setFirstname(emplyeeDto.getFirstName());
        newEmployee.setLastname(emplyeeDto.getLastName());
        newEmployee.setBirthDay(emplyeeDto.getBirthday());
        newEmployee.setDiplomeLevel(emplyeeDto.getDiplomeLevel());
        newEmployee.setAddress(addressRepository.findById(emplyeeDto.getAddressId()).orElseThrow());

        Employee createdEmployee = this.employeeRepository.save(newEmployee);
        return changeToEmployeeDto(createdEmployee);



    }

    public EmployeeDto changeToEmployeeDto (Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getBirthDay(),
                employee.getDiplomeLevel(),
                employee.getAddress().getId()
        );
    }
}
