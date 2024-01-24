package fr.doandgo.gestionRH.service;

import fr.doandgo.gestionRH.dto.EmployeeDto;
import fr.doandgo.gestionRH.entity.Employee;
import fr.doandgo.gestionRH.repository.AddressRepository;
import fr.doandgo.gestionRH.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private AddressRepository addressRepository;

    public void createEmployee(EmployeeDto emplyeeDto){
        Employee newEmployee = new Employee();
        newEmployee.setFirstname(emplyeeDto.getFirstName());
        newEmployee.setLastname(emplyeeDto.getLastName());
        newEmployee.setBirthDay(emplyeeDto.getBirthday());
        newEmployee.setDiplomeLevel(emplyeeDto.getDiplomeLevel());
        newEmployee.setAddress(addressRepository.findById(emplyeeDto.getAddressId()).orElseThrow());

        this.employeeRepository.save(newEmployee);


    }
}
