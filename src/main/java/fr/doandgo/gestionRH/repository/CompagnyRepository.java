package fr.doandgo.gestionRH.repository;

import fr.doandgo.gestionRH.entity.Compagny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompagnyRepository extends JpaRepository<Compagny,Integer> {
    void deleteById(Integer id);
    Optional<Compagny> findCompagnyByName(String name);
}
