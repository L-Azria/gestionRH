package fr.doandgo.gestionRH.controller;

import fr.doandgo.gestionRH.dto.CityDto;
import fr.doandgo.gestionRH.entity.City;
import fr.doandgo.gestionRH.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Component
@RestController
@AllArgsConstructor
public class CityController extends AbstractController<CityDto> {
    private CityService cityService;


    @Override
    public CityDto getDtoById(Integer id) {
        return null;
    }

    @Override
    public List<CityDto> getAllDto() {
        return null;
    }

    @Override
    public void createDto(CityDto dto) {
        this.cityService.createCity(dto);

    }

    @Override
    public void updateDto(Integer id, CityDto dto) {

    }

    @Override
    public void deleteDto(Integer id) {

    }
}
