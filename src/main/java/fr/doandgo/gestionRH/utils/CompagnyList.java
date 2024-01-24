package fr.doandgo.gestionRH.utils;

import fr.doandgo.gestionRH.controller.CompagnyController;
import fr.doandgo.gestionRH.dto.CompagnyDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;


public class CompagnyList {
    private Scanner scanner;

    public CompagnyList(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayCompagnies(List<CompagnyDto> compagnyDtoList) {
        for (CompagnyDto c : compagnyDtoList) {
            System.out.println(c);
        }
    }

    public CompagnyDto selectCompagny(List<CompagnyDto> compagnyDtoList) {
        int selectedCompanyId = scanner.nextInt();
        scanner.nextLine();

        // Rechercher la compagnie avec l'ID spécifié dans la liste
        for (CompagnyDto c : compagnyDtoList) {
            if (c.getId() == selectedCompanyId) {
                return c;
            }
        }
        // Aucune compagnie trouvée avec l'ID spécifié
        return null;
    }
}
