package fr.doandgo.gestionRH.dto;

import fr.doandgo.gestionRH.entity.Address;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AddressDto {
    private Integer id;
    private String number;
    private String street;

    private Integer codePostal;
    private String nameCity;

    public AddressDto(){}

    public AddressDto(Integer id, String number, String street, Integer codePostal, String nameCity) {
        this.id = id;
                this.number = number;
                this.street = street;
                this.codePostal  = codePostal;
                this.nameCity = nameCity;
    }




}
