package fr.doandgo.gestionRH.ihm;

import fr.doandgo.gestionRH.dto.AddressDto;
import fr.doandgo.gestionRH.dto.EmployeeDto;
import fr.doandgo.gestionRH.enums.Diplome;
import fr.doandgo.gestionRH.utils.DiplomeList;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import static fr.doandgo.gestionRH.utils.DateFormatUtil.convertUserInputToDate;

@AllArgsConstructor
@Data
@Component
public class DisplayMenuContract {
    private static Scanner scanner = new Scanner(System.in);
    public void displayMenuContract() {
        int choix;
        do {
            System.out.println("Voulez-vous :");
            System.out.println("1. Lister les contrats");
            System.out.println("2. Créer un nouveau contrat");
            System.out.println("3. Mettre à jour un contrat");
            System.out.println("4. Supprimer un contrat");
            System.out.println("99. Retour en arrière");
            System.out.println("Choix n° : ");
            choix = scanner.nextInt();

            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("Liste les contrats : ");

                    break;
                case 2:
                    System.out.println("Liste les contrats : ");


                    break;
                case 3:
                    System.out.println("Saisie l'id de la compagnie à modifier: ");

                    break;
                case 4:
                    System.out.println("Saisie l'id de la compagnie à supprimer: ");

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
