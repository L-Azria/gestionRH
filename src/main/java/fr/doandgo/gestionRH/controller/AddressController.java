package fr.doandgo.gestionRH.controller;

import fr.doandgo.gestionRH.dto.AddressDto;
import fr.doandgo.gestionRH.service.AddressService;
import fr.doandgo.gestionRH.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Component
@RestController
@AllArgsConstructor
public class AddressController extends AbstractController<AddressDto>{
    private AddressService addressService;


    @Override
    public AddressDto getDtoById(Integer id) {
        return null;
    }

    @Override
    public List<AddressDto> getAllDto() {
        return null;
    }

    @Override
    public void createDto(AddressDto dto) {
         /*this.addressService.createAddress(dto);*/

    }
    public AddressDto createAddressDto(AddressDto dto) {
        AddressDto createdAddressDto = this.addressService.createAddress(dto);
        return createdAddressDto;
    }



    @Override
    public void updateDto(Integer id, AddressDto dto) {

    }

    @Override
    public void deleteDto(Integer id) {

    }
}
