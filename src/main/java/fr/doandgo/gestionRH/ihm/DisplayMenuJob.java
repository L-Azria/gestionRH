package fr.doandgo.gestionRH.ihm;

import fr.doandgo.gestionRH.controller.CompagnyController;
import fr.doandgo.gestionRH.controller.JobController;
import fr.doandgo.gestionRH.dto.CompagnyDto;
import fr.doandgo.gestionRH.dto.JobDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Data
@Component
public class DisplayMenuJob {

    private static Scanner scanner = new Scanner(System.in);

    private JobController jobController;

    private JobDto jobDto;

    public void displayMenuJob() {
        int choix;
        do {
            System.out.println("Voulez-vous :");
            System.out.println("1. Lister les postes de travail pour une compagnie");
            System.out.println("2. Créer une nouvelle poste de travail pour une compagnie");
            System.out.println("3. Mettre à jour une poste de travail pour une compagnie");
            System.out.println("4. Supprimer une poste de travail pour une compagnie");
            System.out.println("99. Retour en arrière");
            System.out.println("Choix n° : ");
            choix = scanner.nextInt();

            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("Saisir le nom d'une compagnie existante: ");
                    String nameCompagny = scanner.nextLine();
                    System.out.println("Liste les postes de travail pour cette compagnie: ");
                    List<JobDto> JobDtoList = jobController.getAllDtoByCompagny(nameCompagny);
                    for(JobDto j : JobDtoList ){
                        System.out.println(j);
                    }
                    break;
                case 2:
                    System.out.println("Saisie le nom de la nouvelle poste de travail: ");

                    break;
                case 3:
                    System.out.println("Saisie l'id de la compagnie à poste de travail: ");

                    break;
                case 4:
                    System.out.println("Saisie l'id de la compagnie à poste de travail: ");

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

