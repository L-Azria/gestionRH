package fr.doandgo.gestionRH.service;

import fr.doandgo.gestionRH.dto.AddressDto;
import fr.doandgo.gestionRH.dto.CityDto;
import fr.doandgo.gestionRH.entity.Address;
import fr.doandgo.gestionRH.entity.City;
import fr.doandgo.gestionRH.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class AddressService {
    private AddressRepository addressRepository;
    private CityService cityService;

/*    public AddressDto findAddressDtoById(Integer id){
        Optional<Address> address = this.addressRepository.findById(id);
        AddressDto addressDto = new AddressDto();
        if(address.isPresent()){
            addressDto = changeToAddressDto(address.get());
        }
        return addressDto;
    }

    private AddressDto changeToAddressDto(Address address) {
        return new AddressDto(
                address.getId(),
                address.getNumber(),
                address.getStreet(),
                address.getCity().getCodePostal(),
                address.getCity().getNameCity());
    }*/


    public AddressDto createAddress(AddressDto dto) {
        Address newAddress = new Address();
        newAddress.setNumber(dto.getNumber());
        newAddress.setStreet(dto.getStreet());

        try {
            City city = this.cityService.findCityByCodePostalAndNameCity(dto.getCodePostal(), dto.getNameCity());
            newAddress.setCity(city);
        } catch (NoSuchElementException e) {
            // City not found, create a new one
            City newCity = this.cityService.createCity(new CityDto(dto.getCodePostal(), dto.getNameCity()));
            newAddress.setCity(newCity);
        }
        Address createdAddress = this.addressRepository.save(newAddress);
        return changeToAddressDto(createdAddress);
    }

    public AddressDto changeToAddressDto(Address address) {
        return new AddressDto(
                address.getId(),
                address.getNumber(),
                address.getStreet(),
                address.getCity().getCodePostal(),
                address.getCity().getNameCity());
    }
}
