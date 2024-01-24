package fr.doandgo.gestionRH.service;

import fr.doandgo.gestionRH.dto.CompagnyDto;
import fr.doandgo.gestionRH.entity.Compagny;
import fr.doandgo.gestionRH.repository.CompagnyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompagnyService {

    private CompagnyRepository compagnyRepository;



    public CompagnyDto findById (Integer id){
        Optional<Compagny> compagny = this.compagnyRepository.findById(id);
        CompagnyDto compagnyDto = new CompagnyDto();
        if(compagny.isPresent()){
             compagnyDto = changeToCompagnyDto(compagny.get());
        } else {
            System.out.println("L'id n'exite pas ");
        }
        return compagnyDto;
    }



    public List<CompagnyDto> findAll (){
        List<Compagny> compagnyList = compagnyRepository.findAll();
        List<CompagnyDto> compagnyDtoList = new ArrayList<>();
        if(!compagnyList.isEmpty()){
            for(Compagny c : compagnyList){
                compagnyDtoList.add(changeToCompagnyDto(c));
            }
        }  else {
            System.out.println("Vous n'avez pas de compagnie");
    }
        return compagnyDtoList;

    }

    public void createCompagny (CompagnyDto compagnyDto){
        Compagny newCompagny = new Compagny(compagnyDto.getName());
        compagnyRepository.save(newCompagny);
    }

    public void updateCompagny(Integer id, CompagnyDto dto) {
       Optional<Compagny> optionalCompagny = this.compagnyRepository.findById(id);

         if (optionalCompagny.isPresent()) {
            Compagny existingCompagny = optionalCompagny.get();

            // Update the name with the new value from the DTO
            existingCompagny.setName(dto.getName());

            // Save the updated entity back to the repository
            this.compagnyRepository.save(existingCompagny);
        } else {
            System.out.println("Compagny with ID " + id + " not found.");
        }


    }

    public void deleteCompagny (Integer id){
        this.compagnyRepository.deleteById(id);
    }

    public CompagnyDto changeToCompagnyDto(Compagny compagny){
        return new CompagnyDto(
                compagny.getId(),
                compagny.getName());
    }

}
