package fr.doandgo.gestionRH.service;

import fr.doandgo.gestionRH.dto.CityDto;
import fr.doandgo.gestionRH.entity.City;
import fr.doandgo.gestionRH.repository.CityRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CityService {
    private CityRepository cityRepository;

    public City createCity (CityDto dto){
        City city = new City();
        city.setCodePostal(dto.getCodePostal());
        city.setNameCity(dto.getNameCity());
        return this.cityRepository.save(city);

    }



    public City findCityByCodePostalAndNameCity(Integer codePostal, String cityName){
        return this.cityRepository.findCityByCodePostalAndNameCity(codePostal, cityName)
                .orElseThrow(() -> new NoSuchElementException("City not found"));
    }

}
