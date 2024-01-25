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

    public EmployeeDto(){};

    public EmployeeDto(Integer id, String firstname, String lastname, Date birthDay, Diplome diplomeLevel, Integer addressId) {
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.birthday = birthDay;
        this.diplomeLevel = diplomeLevel;
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Employee : " +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", diplomeLevel=" + diplomeLevel +
                ", address=" + addressId ;
    }
}
