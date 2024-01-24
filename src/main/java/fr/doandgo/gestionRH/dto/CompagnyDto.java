package fr.doandgo.gestionRH.dto;

import fr.doandgo.gestionRH.entity.Compagny;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class CompagnyDto {
    private Integer id;
    private String name;

    public CompagnyDto(Compagny compagny){
        this.id = compagny.getId();
        this.name = compagny.getName();
    }


    public CompagnyDto(){

    }



    public Compagny toCompagny() {
        Compagny compagny = new Compagny();
        compagny.setId(this.getId());
        compagny.setName(this.getName());
        return compagny;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name = " + name ;
    }
}
