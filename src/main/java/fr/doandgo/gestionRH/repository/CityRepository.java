package fr.doandgo.gestionRH.repository;

import fr.doandgo.gestionRH.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    Optional<City> findCityByCodePostalAndNameCity(Integer codePostal, String nameCity );
}
