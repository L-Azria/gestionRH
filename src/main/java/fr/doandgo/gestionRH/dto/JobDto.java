package fr.doandgo.gestionRH.dto;

import fr.doandgo.gestionRH.entity.Compagny;
import fr.doandgo.gestionRH.entity.Job;
import fr.doandgo.gestionRH.enums.Category;
import fr.doandgo.gestionRH.enums.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
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
    private List<String> managed;
    private String compagny;

    public JobDto() {
    }
    public JobDto(Job job){
        this.name = job.getName();
        this.service = job.getService();
        this.category = job.getCategory();
        this.managed = Collections.singletonList(job.getManaged().toString());
        this.compagny = job.getCompagny().toString();

    }


    public JobDto(Integer id, String name, Service service, Category category, List<Job> managed, Compagny compagny) {
    }
}
