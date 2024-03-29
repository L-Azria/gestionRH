package fr.doandgo.gestionRH.repository;

import fr.doandgo.gestionRH.entity.Compagny;
import fr.doandgo.gestionRH.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    List<Job> findJobsByCompagny(Compagny compagny);
}
