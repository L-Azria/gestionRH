package fr.doandgo.gestionRH.controller;

import fr.doandgo.gestionRH.dto.CompagnyDto;
import fr.doandgo.gestionRH.service.CompagnyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
@AllArgsConstructor

public class CompagnyController extends AbstractController<CompagnyDto>{

    private CompagnyService compagnyService;
    @Override
    public CompagnyDto getDtoById(Integer id) {
        return this.compagnyService.findById(id);
    }

    @Override
    public List<CompagnyDto> getAllDto() {
        return this.compagnyService.findAll();

    }

    @Override
    public void createDto(CompagnyDto dto) {
        this.compagnyService.createCompagny(dto);
    }

    @Override
    public void updateDto(Integer id, CompagnyDto dto) {
        this.compagnyService.updateCompagny(id, dto);
    }

    @Override
    public void deleteDto(Integer id) {
        this.compagnyService.deleteCompagny(id);

    }

}
