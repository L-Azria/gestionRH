package fr.doandgo.gestionRH.ihm;

import fr.doandgo.gestionRH.controller.AddressController;
import fr.doandgo.gestionRH.controller.CityController;
import fr.doandgo.gestionRH.controller.EmployeeController;
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
public class DisplayMenuEmployee {

    private static Scanner scanner = new Scanner(System.in);

    private CityController cityController;
    private AddressController addressController;
    private EmployeeController employeeController;



    public void displayMenuEmplyee() {
        int choix;
        do {
            System.out.println("Voulez-vous :");
            System.out.println("1. Lister les employées");
            System.out.println("2. Créer une nouvelle employée");
            System.out.println("3. Mettre à jour une employée");
            System.out.println("4. Supprimer une employée");
            System.out.println("99. Retour en arrière");
            System.out.println("Choix n° : ");
            choix = scanner.nextInt();

            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("Liste des compagnies : ");

                    break;
                case 2:
                    EmployeeDto newEmployeeDto = new EmployeeDto();
                    System.out.println("Saisie le prénom du nouveau employé: ");
                    String newFirstName = scanner.nextLine();
                    newEmployeeDto.setFirstName(newFirstName);

                    System.out.println("Saisie le nom du nouveau employé: ");
                    String newLastName = scanner.nextLine();
                    newEmployeeDto.setLastName(newLastName);

                    System.out.println("Saisie la date de naissance du nouveau employé (dd/MM/YYYY): ");
                    String userInput = scanner.nextLine();
                    try {
                        Date newBirthDay = convertUserInputToDate(userInput);
                        newEmployeeDto.setBirthday(newBirthDay);
                    } catch (ParseException e) {
                        System.out.println("Format de date incorrect");
                    }

                    System.out.println("Saisie le niveau de diplôme le plus élevé: ");
                    DiplomeList.displayDiplome();
                    Diplome chooseDiplome = DiplomeList.chooseDiplome();
                    newEmployeeDto.setDiplomeLevel(chooseDiplome);

                    AddressDto newAddressDto = new AddressDto();
                    System.out.println("Saisie l'adresse de l'employé: ");
                    System.out.println("Numéro: ");
                    String numberAddress = scanner.nextLine();
                    newAddressDto.setNumber(numberAddress);
                    System.out.println("Rue/Voie: ");
                    String streetAddress = scanner.nextLine();
                    newAddressDto.setStreet(streetAddress);
                    System.out.println("Code Postal: ");
                    Integer newCodePostal = scanner.nextInt();
                    scanner.nextLine();
                    newAddressDto.setCodePostal(newCodePostal);
                    System.out.println("Ville: ");
                    String newNameCity = scanner.nextLine();
                    newAddressDto.setNameCity(newNameCity);
                    AddressDto createdAddressDto = addressController.createAddressDto(newAddressDto);

                    newEmployeeDto.setAddressId(createdAddressDto.getId());
                    employeeController.createDto(newEmployeeDto);













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
