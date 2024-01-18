package fr.doandgo.gestionRH.ihm;

//import fr.doandgo.gestionRH.controller.AbstractCompagnyController;
import fr.doandgo.gestionRH.controller.CompagnyController;
import fr.doandgo.gestionRH.dto.CompagnyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
@AllArgsConstructor
@Data
@Component
public class DisplayMenuCompagny {
    private static Scanner scanner = new Scanner(System.in);

    private CompagnyController compagnyController;

    private CompagnyDto compagnyDto;

    public void displayMenuCompagny() {
        int choix;
        do {
            System.out.println("Voulez-vous :");
            System.out.println("1. Lister les compagnies");
            System.out.println("2. Créer une nouvelle compagnie");
            System.out.println("3. Mettre à jour une compagnie");
            System.out.println("4. Supprimer une compagnie");
            System.out.println("99. Retour en arrière");
            System.out.println("Choix n° : ");
            choix = scanner.nextInt();

            scanner.nextLine(); // Pour consommer la nouvelle ligne restante après la lecture de l'entier

            switch (choix) {
                case 1:
                    System.out.println("Liste des compagnies : ");
                    List<CompagnyDto> compagnyDtoList = compagnyController.getAllDto();
                    for(CompagnyDto c : compagnyDtoList ){
                        System.out.println(c);
                    }
                    break;
                case 2:
                    System.out.println("Saisie le nom de la nouvelle compagnie: ");
                    String name = scanner.nextLine(); // Lire le nom de la nouvelle compagnie depuis la console
                    CompagnyDto newCompagnyDto = new CompagnyDto();
                    newCompagnyDto.setName(name);
                    compagnyController.createDto(newCompagnyDto);
                    break;
                case 3:
                    System.out.println("Saisie l'id de la compagnie à modifier: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    CompagnyDto cUpdate = compagnyController.getDtoById(id);
                    System.out.println(cUpdate);
                    System.out.println("Saisie le nouveau nom de la compagnie: ");
                    String newName = scanner.nextLine();
                    cUpdate.setName(newName);
                    compagnyController.updateDto(id, cUpdate);
                    break;
                case 4:
                    System.out.println("Saisie l'id de la compagnie à supprimer: ");
                    int idDelete = scanner.nextInt();
                    scanner.nextLine();
                    CompagnyDto cDelete = compagnyController.getDtoById(idDelete);
                    System.out.println(cDelete);
                    System.out.println("Saisie de nouveau l'id de la compagnie pour confirmer la supression: ");
                    int idDeleteConfirm = scanner.nextInt();
                    if(idDelete != idDeleteConfirm){
                        System.out.println("l'id de la compagnie n'a pas été confirmé, la compagnie n'est pas supprimée");
                    } else {
                        compagnyController.deleteDto(idDeleteConfirm);
                    }
                    break;
                case 99:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix non valide. Veuillez réessayer.");
            }
        } while (choix != 99);
    }


}
