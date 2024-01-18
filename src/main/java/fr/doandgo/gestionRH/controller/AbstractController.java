package fr.doandgo.gestionRH.controller;

import java.util.List;

public abstract class AbstractController<T> {

    protected abstract T getDtoById(Integer id);

    protected abstract List<T> getAllDto();

    protected abstract void createDto(T dto);

    protected abstract void updateDto(Integer id, T dto);

    protected abstract void deleteDto(Integer id);
}
