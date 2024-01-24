package fr.doandgo.gestionRH.entity;

import fr.doandgo.gestionRH.dto.JobDto;
import fr.doandgo.gestionRH.enums.Category;
import fr.doandgo.gestionRH.enums.Service;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@EqualsAndHashCode()
@Entity
@Data
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Service service;
    private Category category;
    @ManyToMany
    @JoinTable(name = "management",
            joinColumns = @JoinColumn(name = "manager_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "managed_id", referencedColumnName = "id"))
    private List<Job> managed;
    @ManyToOne
    private Compagny compagny;



    public Job(String name, Service service, Category category, Compagny compagny) {
        this.name = name;
        this.service = service;
        this.category = category;
        this.compagny = compagny;
    }

    public Job() {

    }

    public JobDto toJobDto(Job job){
        return new JobDto(
                job.getId(),
                job.getName(),
                job.getService(),
                job.getCategory(),
                //job.getManaged(),
                job.getCompagny()
        );
    }


}
