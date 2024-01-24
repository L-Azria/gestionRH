package fr.doandgo.gestionRH.dto;

import fr.doandgo.gestionRH.entity.Address;
import fr.doandgo.gestionRH.enums.Diplome;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Component
public class EmployeeDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private Diplome diplomeLevel;
    private Integer addressId;

}
