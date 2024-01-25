package fr.doandgo.gestionRH.ihm;

import fr.doandgo.gestionRH.controller.*;
import fr.doandgo.gestionRH.dto.*;
import fr.doandgo.gestionRH.enums.Diplome;
import fr.doandgo.gestionRH.utils.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static fr.doandgo.gestionRH.utils.DateFormatUtil.convertUserInputToDate;

@AllArgsConstructor
@Data
@Component
public class DisplayMenuContract {
    private static Scanner scanner = new Scanner(System.in);

    private JobController jobController;
    private EmployeeController employeeController;
    private CompagnyController compagnyController;
    private AddressController addressController;
    private ContractController contractController;
    public void displayMenuContract() {
        int choix;
        do {
            System.out.println("Voulez-vous :");
            System.out.println("1. Lister les contrats par employé");
            System.out.println("2. Créer un nouveau contrat");
            System.out.println("3. Mettre à jour un contrat");
            System.out.println("4. Supprimer un contrat");
            System.out.println("99. Retour en arrière");
            System.out.println("Choix n° : ");
            choix = scanner.nextInt();

            scanner.nextLine();

            switch (choix) {
                case 1:
                    EmployeeList employeeList = new EmployeeList(scanner);

                    System.out.println("List des employés : ");
                    employeeList.displayEmployee(employeeController.getAllDto());
                    System.out.println("Choisir l'employé dont vous voulez voir le contrat : ");
                    EmployeeDto selectedEmployeeId = employeeList.selectEmployee(employeeController.getAllDto());
                    System.out.println("List des contrats liés à cet employé");
                    List<ContractDto> contractDtoList = contractController.getContractDtoByEmployee(selectedEmployeeId);
                    for (ContractDto c : contractDtoList){
                        System.out.println(c);
                    }




                    break;
                case 2:
                    ContractDto contractDto = new ContractDto();
                    System.out.println("Choisir le type de contrat : ");
                    ContractTypeList.displayContractType();
                    contractDto.setContractTypes(ContractTypeList.chooseContractTypes());

                    System.out.println("Saisie la date de début du contrat (dd/MM/YYYY): ");
                    String userInputStartDate = scanner.nextLine();
                    try {
                        Date startDate = convertUserInputToDate(userInputStartDate);
                        contractDto.setStartDate(startDate);
                    } catch (ParseException e) {
                        System.out.println("Format de date incorrect");
                    }

                    System.out.println("Saisie la date de fin du contrat (dd/MM/YYYY): ");
                    String userInputEndDate = scanner.nextLine();
                    try {
                        Date endDate = convertUserInputToDate(userInputEndDate);
                        contractDto.setEndDate(endDate);
                    } catch (ParseException e) {
                        System.out.println("Format de date incorrect");
                    }

                    System.out.println("Salaire: ");
                    Double salary = scanner.nextDouble();
                    scanner.nextLine();
                    contractDto.setSalary(salary);

                    System.out.println("Choisir la raison de terminer : ");
                    TerminationReasonList.displayTerminationReason();
                    contractDto.setTerminationReason(TerminationReasonList.chooseTerminationReason());

                    System.out.println("Choisir la condition de travail : ");
                    WorkingConditionList.displayWorkingCondition();
                    contractDto.setWorkingCondition(WorkingConditionList.chooseWorkingCondition());

                    JobList jobList = new JobList(scanner);
                    System.out.println("Liste les postes : ");
                    jobList.displayJob(jobController.getAllDto());
                    System.out.println("Choisir le poste concerné par le contrat : ");
                    JobDto selectedJobId = jobList.selectJob(jobController.getAllDto());
                    contractDto.setJobId(selectedJobId.getId());


                    // créer un nouveau employé pour le contrat
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
                    EmployeeDto createdEmployeeDto = employeeController.createEmployeeDto(newEmployeeDto);


                    contractDto.setEmployeeId(createdEmployeeDto.getId());
                    contractController.createDto(contractDto);


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
