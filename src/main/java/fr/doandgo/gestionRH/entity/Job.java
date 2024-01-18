package fr.doandgo.gestionRH.entity;

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

    public Job() {
    }

}
