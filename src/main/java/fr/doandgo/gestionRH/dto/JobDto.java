package fr.doandgo.gestionRH.dto;

import fr.doandgo.gestionRH.entity.Compagny;
import fr.doandgo.gestionRH.entity.Job;
import fr.doandgo.gestionRH.enums.Category;
import fr.doandgo.gestionRH.enums.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
@Data
@Component
public class JobDto {
    private Integer id;
    private String name;
    private Service service;
    private Category category;
    //private List<String> managed;
    private CompagnyDto compagny;

    public JobDto() {
    }
    /*public JobDto(Job job){
        this.id = job.getId();
        this.name = job.getName();
        this.service = job.getService();
        this.category = job.getCategory();
        //this.managed = Collections.singletonList(job.getManaged().toString());
        this.compagny = new CompagnyDto(job.getCompagny());

    }*/


    public JobDto(Integer id, String name, Service service, Category category, Compagny compagny) {
        this.id = id;
        this.name = name;
        this.service = service;
        this.category = category;
        this.compagny =  new CompagnyDto(compagny.getId(), compagny.getName());
    }






    @Override
    public String toString() {
        return " Poste de l'entreprise : " +
                " id=" + id +
                ", name=" + name +
                ", service=" + service +
                ", category=" + category;
    }
}
