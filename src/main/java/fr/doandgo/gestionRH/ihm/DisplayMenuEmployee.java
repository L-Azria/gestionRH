package fr.doandgo.gestionRH.ihm;

import fr.doandgo.gestionRH.controller.AddressController;
import fr.doandgo.gestionRH.controller.CityController;
import fr.doandgo.gestionRH.controller.CompagnyController;
import fr.doandgo.gestionRH.controller.EmployeeController;
import fr.doandgo.gestionRH.dto.AddressDto;
import fr.doandgo.gestionRH.dto.CompagnyDto;
import fr.doandgo.gestionRH.dto.ContractDto;
import fr.doandgo.gestionRH.dto.EmployeeDto;
import fr.doandgo.gestionRH.enums.Category;
import fr.doandgo.gestionRH.enums.Diplome;
import fr.doandgo.gestionRH.enums.Service;
import fr.doandgo.gestionRH.utils.*;
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
    private CompagnyController compagnyController;



    public void displayMenuEmplyee() {
        int choix;
        do {
            System.out.println(" ");
            System.out.println("Voulez-vous :");
            System.out.println("1. Lister les employées");
            System.out.println("2. Mettre à jour une employée");
            System.out.println("3. Supprimer une employée");
            System.out.println("99. Retour en arrière");
            System.out.println("Choix n° : ");
            choix = scanner.nextInt();

            scanner.nextLine();

            switch (choix) {
                case 1:
                    EmployeeList employeeList = new EmployeeList(scanner);
                    System.out.println("List des employés : ");
                    employeeList.displayEmployee(employeeController.getAllDto());
                    break;

                case 2:
                    EmployeeList employeeListToEdit = new EmployeeList(scanner);

                    System.out.println("List des employés : ");
                    employeeListToEdit.displayEmployee(employeeController.getAllDto());
                    System.out.println("Choisir l'employé dont vous voulez modifier : ");
                    EmployeeDto selectedEmployeeToEdit = employeeListToEdit.selectEmployee(employeeController.getAllDto());

                    int selectedField;
                    do {
                        System.out.println(" ");
                        System.out.println("Voulez-vous changer :");
                        System.out.println("1. Le prénom ");
                        System.out.println("2. Le nom");
                        System.out.println("3. La date de naissance");
                        System.out.println("4. Le niveau du diplôme");
                        System.out.println("99. Fini les modifications");
                        System.out.println("Choix n° : ");
                        selectedField = scanner.nextInt();

                        scanner.nextLine();

                        switch (selectedField) {
                            case 1:
                                System.out.println("Saisir le nouveau prénom : ");
                                String newFirstName = scanner.nextLine();
                                selectedEmployeeToEdit.setFirstName(newFirstName);
                                break;
                            case 2:
                                System.out.println("Saisir le nouveau nom: ");
                                String newLasttName = scanner.nextLine();
                                selectedEmployeeToEdit.setLastName(newLasttName);
                                break;

                            case 3:
                                System.out.println("Saisir la nouvelle date de naissance : ");
                                String inputNewBD = scanner.nextLine();
                                try {
                                    Date newBD = convertUserInputToDate(inputNewBD);
                                    assert selectedEmployeeToEdit != null;
                                    selectedEmployeeToEdit.setBirthday(newBD);
                                } catch (ParseException e) {
                                    System.out.println("Format de date incorrect");
                                }
                                break;

                            case 4:
                                System.out.println("Choisir le nouveau niveau de diplôme: ");
                                DiplomeList.displayDiplome();
                                Diplome newDiplome = DiplomeList.chooseDiplome();
                                selectedEmployeeToEdit.setDiplomeLevel(newDiplome);
                                break;
                            case 99:
                                System.out.println("Retour au menu principal.");
                                break;
                            default:
                                System.out.println("Option invalide.");
                        }


                        employeeController.updateDto(selectedEmployeeToEdit.getId(), selectedEmployeeToEdit);
                        System.out.println("Employé mis à jour : " + selectedEmployeeToEdit);
                    } while (selectedField != 99);

                    break;
                case 3:
                    EmployeeList employeeListForDelete = new EmployeeList(scanner);
                    System.out.println("Liste des employé: ");
                    employeeListForDelete.displayEmployee(employeeController.getAllDto());
                    System.out.println("Saisir l'id de l'employé que vous voulez supprimer: ");
                    EmployeeDto selectedEmployeeDtoToDelete = employeeListForDelete.selectEmployee(employeeController.getAllDto());
                    if (selectedEmployeeDtoToDelete != null) {
                        employeeController.deleteDto(selectedEmployeeDtoToDelete.getId());
                        System.out.println("L'employé " + selectedEmployeeDtoToDelete + " a été supprimé");
                    } else {
                        System.out.println("L'employé n'a pas été supprimé");
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
