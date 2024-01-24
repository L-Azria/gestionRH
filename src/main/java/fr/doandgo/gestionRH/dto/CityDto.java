package fr.doandgo.gestionRH.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CityDto {
    private Integer id;
    private Integer codePostal;
    private String nameCity;



    public CityDto() {

    }


    public CityDto(Integer codePostal, String nameCity) {
        this.codePostal = codePostal;
        this.nameCity = nameCity;
    }
}
