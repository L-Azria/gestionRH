package fr.doandgo.gestionRH.ihm;

import fr.doandgo.gestionRH.controller.*;
import fr.doandgo.gestionRH.dto.*;
import fr.doandgo.gestionRH.enums.*;
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
            System.out.println(" ");
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
                    ContractList contractList = new ContractList(scanner);
                    System.out.println("Liste des contrats: ");
                    contractList.displayContract(contractController.getAllDto());
                    System.out.println("Saisir l'id du contrat que vous voulez modifier: ");
                    ContractDto selectedContractDtoToEdit = contractList.selectContract(contractController.getAllDto());
                    if (selectedContractDtoToEdit != null) {
                        System.out.println("Poste sélectionnée : " + selectedContractDtoToEdit);
                    } else {
                        System.out.println("Aucune poste trouvée avec l'ID spécifié.");
                    }

                    int selectedField;
                    do {
                        System.out.println(" ");
                        System.out.println("Voulez-vous changer :");
                        System.out.println("1. Le type du contrat");
                        System.out.println("2. La date de début");
                        System.out.println("3. La date de fin");
                        System.out.println("4. Le salaire");
                        System.out.println("5. La raison de mettre fin au contrat");
                        System.out.println("6. La condition du travail");
                        System.out.println("99. Fini les modifications");
                        System.out.println("Choix n° : ");
                        selectedField = scanner.nextInt();

                        scanner.nextLine();

                        switch (selectedField) {
                            case 1:
                                System.out.println("Choisir le nouveau type de contrat: ");
                                ContractTypeList.displayContractType();
                                ContractTypes newCT = ContractTypeList.chooseContractTypes();
                                assert selectedContractDtoToEdit != null;
                                selectedContractDtoToEdit.setContractTypes(newCT);
                                break;

                            case 2:
                                System.out.println("Saisir la nouvelle date de début : ");
                                String inputNewStartDate = scanner.nextLine();
                                try {
                                    Date newStartDate = convertUserInputToDate(inputNewStartDate);
                                    assert selectedContractDtoToEdit != null;
                                    selectedContractDtoToEdit.setStartDate(newStartDate);
                                } catch (ParseException e) {
                                    System.out.println("Format de date incorrect");
                                }
                                break;

                            case 3:
                                System.out.println("Saisir la nouvelle date de début : ");
                                String inputNewEndDate = scanner.nextLine();
                                try {
                                    Date newEndDate = convertUserInputToDate(inputNewEndDate);
                                    assert selectedContractDtoToEdit != null;
                                    selectedContractDtoToEdit.setEndDate(newEndDate);
                                } catch (ParseException e) {
                                    System.out.println("Format de date incorrect");
                                }
                                break;

                            case 4 :
                                System.out.println("Saisir le nouveau salaire : ");
                                Double newSalary = scanner.nextDouble();
                                scanner.nextLine();
                                assert selectedContractDtoToEdit != null;
                                selectedContractDtoToEdit.setSalary(newSalary);
                                break;

                            case 5:
                                System.out.println("Choisir la nouvelle raison de mettre fin au contrat: ");
                                TerminationReasonList.displayTerminationReason();
                                TerminationReason newTR = TerminationReasonList.chooseTerminationReason();
                                assert selectedContractDtoToEdit != null;
                                selectedContractDtoToEdit.setTerminationReason(newTR);
                                break;

                            case 6:
                                System.out.println("Choisir la nouvelle condition du travail: ");
                                WorkingConditionList.displayWorkingCondition();
                                WorkingCondition newWCond = WorkingConditionList.chooseWorkingCondition();
                                assert selectedContractDtoToEdit != null;
                                selectedContractDtoToEdit.setWorkingCondition(newWCond);
                                break;

                            case 99:
                                System.out.println("Retour au menu principal.");
                                break;
                            default:
                                System.out.println("Option invalide.");
                        }


                        contractController.updateDto(selectedContractDtoToEdit.getId(), selectedContractDtoToEdit);
                        System.out.println("Poste mis à jour : " + selectedContractDtoToEdit);
                    } while (selectedField != 99);

                    break;
                case 4:
                    ContractList contractListForDelete = new ContractList(scanner);
                    System.out.println("Liste des contrats: ");
                    contractListForDelete.displayContract(contractController.getAllDto());
                    System.out.println("Saisir l'id du contrat que vous voulez supprimer: ");
                    ContractDto selectedContractDtoToDelete = contractListForDelete.selectContract(contractController.getAllDto());
                    if (selectedContractDtoToDelete != null) {
                        contractController.deleteDto(selectedContractDtoToDelete.getId());
                        System.out.println("Le contrat " + selectedContractDtoToDelete + " a été supprimé");
                    } else {
                        System.out.println("Le contrat n'a pas été supprimé");
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
