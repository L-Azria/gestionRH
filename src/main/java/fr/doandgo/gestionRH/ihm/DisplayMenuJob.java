package fr.doandgo.gestionRH.ihm;

import fr.doandgo.gestionRH.controller.CompagnyController;
import fr.doandgo.gestionRH.controller.JobController;
import fr.doandgo.gestionRH.dto.CompagnyDto;
import fr.doandgo.gestionRH.dto.JobDto;
import fr.doandgo.gestionRH.entity.Compagny;
import fr.doandgo.gestionRH.enums.Category;
import fr.doandgo.gestionRH.enums.Service;
import fr.doandgo.gestionRH.utils.CategoryList;
import fr.doandgo.gestionRH.utils.CompagnyList;
import fr.doandgo.gestionRH.utils.ServiceList;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

@AllArgsConstructor
@Data
@Component
public class DisplayMenuJob {

    private static Scanner scanner = new Scanner(System.in);

    private JobController jobController;
    private CompagnyController compagnyController;

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
                    CompagnyList compagnyList = new CompagnyList(scanner);

                    System.out.println("Liste des compagnies : ");
                    compagnyList.displayCompagnies(compagnyController.getAllDto());

                    System.out.print("Entrez l'ID de la compagnie que vous souhaitez sélectionner : ");
                    CompagnyDto selectedCompanyId = compagnyList.selectCompagny(compagnyController.getAllDto());


                    // Vérifier si la compagnie a été trouvée
                    if (selectedCompanyId != null) {
                        System.out.println("Compagnie sélectionnée : " + selectedCompanyId);


                    JobDto newJobDto = new JobDto();

                    newJobDto.setCompagny(selectedCompanyId);

                    System.out.println("Saisir le nom de la poste: ");
                    String newNamePost = scanner.nextLine();
                    newJobDto.setName(newNamePost);

                    System.out.println("Choisir le service pour le poste: ");
                    ServiceList.displayServices();
                   Service chooseServiceName = ServiceList.chooseService();
                    newJobDto.setService(chooseServiceName);

                    System.out.println("Choisir le catégorie pour le poste: ");
                    CategoryList.displayCategories();
                    Category chooseCategoryName = CategoryList.chooseCategory();
                    newJobDto.setCategory(chooseCategoryName);

                    /*List<String> postManaged = new ArrayList<>();
                    System.out.println("Saisir le nom d'un poste qu'il manage (ou appuyez sur Entrée pour terminer) : ");
                    String managedPost;
                    while (!(managedPost = scanner.nextLine()).isEmpty()) {
                        postManaged.add(managedPost);
                        System.out.println("Saisir le nom d'un autre poste qu'il manage (ou appuyez sur Entrée pour terminer) : ");
                    }*/
                    /*newJobDto.setManaged(postManaged);
                    System.out.println("newJobDto" + newJobDto);*/

                    jobController.createDto(newJobDto);

                    } else {
                        System.out.println("Aucune compagnie trouvée avec l'ID spécifié.");
                    }


                    break;
                case 3:
                    CompagnyList compagnyListForEdit = new CompagnyList(scanner);

                    System.out.println("Liste des compagnies : ");
                    compagnyListForEdit.displayCompagnies(compagnyController.getAllDto());

                    System.out.print("Entrez l'ID de la compagnie que vous souhaitez sélectionner : ");
                    CompagnyDto selectedCompanyIdForEdit = compagnyListForEdit.selectCompagny(compagnyController.getAllDto());
                    System.out.println("Liste les postes de travail pour cette compagnie: ");
                    List<JobDto> JobDtoListToEdit = jobController.getAllDtoByCompagny(selectedCompanyIdForEdit.getName());
                    for(JobDto j : JobDtoListToEdit ){
                        System.out.println(j);
                    }
                    System.out.print("Entrez l'ID de la poste que vous souhaitez modifier : ");
                    int selectedPostIdToEdit = scanner.nextInt();
                    scanner.nextLine();
                    // Rechercher le job avec l'ID spécifié dans la liste
                    JobDto selectedJobDtoToEdit = null;
                    for (JobDto j : JobDtoListToEdit) {
                        if (j.getId() == selectedPostIdToEdit) {
                            selectedJobDtoToEdit = j;
                            break;
                        }
                    }
                    // Vérifier si le job a été trouvée
                    if (selectedJobDtoToEdit != null) {
                        System.out.println("Poste sélectionnée : " + selectedJobDtoToEdit);
                    } else {
                        System.out.println("Aucune poste trouvée avec l'ID spécifié.");
                    }

                    int selectedField;
                    do {
                        System.out.println("Voulez-vous changer :");
                        System.out.println("1. Le nom du poste");
                        System.out.println("2. Le service");
                        System.out.println("3. La catégorie");
                        System.out.println("99. Fini les modifications");
                        System.out.println("Choix n° : ");
                        selectedField = scanner.nextInt();

                        scanner.nextLine();

                        switch (selectedField) {
                            case 1:
                                System.out.println("Saisir le nouveau nom du poste : ");
                                String newNamePost = scanner.nextLine();
                                selectedJobDtoToEdit.setName(newNamePost);
                                break;
                            case 2:
                                System.out.println("Choisir le nouveau service pour le poste: ");
                                ServiceList.displayServices();
                                Service newService = ServiceList.chooseService();
                                selectedJobDtoToEdit.setService(newService);
                                break;
                            case 3:
                                System.out.println("Choisir la nouvelle catégorie pour le poste: ");
                                CategoryList.displayCategories();
                                Category newCategory = CategoryList.chooseCategory();
                                selectedJobDtoToEdit.setCategory(newCategory);
                                break;
                            case 99:
                                System.out.println("Retour au menu principal.");
                                break;
                            default:
                                System.out.println("Option invalide.");
                        }

                        // Mettre à jour le Job
                        jobController.updateDto(selectedPostIdToEdit, selectedJobDtoToEdit);
                        System.out.println("Poste mis à jour : " + selectedJobDtoToEdit);
                    } while (selectedField != 99);



                    break;
                case 4:
                    CompagnyList compagnyListForDelete = new CompagnyList(scanner);

                    System.out.println("Liste des compagnies : ");
                    compagnyListForDelete.displayCompagnies(compagnyController.getAllDto());

                    System.out.print("Entrez l'ID de la compagnie que vous souhaitez sélectionner : ");
                    CompagnyDto selectedCompanyIdForDelete = compagnyListForDelete.selectCompagny(compagnyController.getAllDto());
                    System.out.println("Liste les postes de travail pour cette compagnie: ");
                    List<JobDto> JobDtoListToDelete = jobController.getAllDtoByCompagny(selectedCompanyIdForDelete.getName());
                    for(JobDto j : JobDtoListToDelete ){
                        System.out.println(j);
                    }
                    System.out.print("Entrez l'ID de la poste que vous souhaitez supprimer : ");
                    int selectedPostIdToDelete = scanner.nextInt();
                    scanner.nextLine();
                    // Rechercher le job avec l'ID spécifié dans la liste
                    JobDto selectedJobDtoToDelete = null;
                    for (JobDto j : JobDtoListToDelete) {
                        if (j.getId() == selectedPostIdToDelete) {
                            selectedJobDtoToDelete = j;
                            break;
                        }
                    }
                    // Vérifier si le job a été trouvée
                    if (selectedJobDtoToDelete != null) {
                        jobController.deleteDto(selectedPostIdToDelete);
                        System.out.println(" Le poste " + selectedJobDtoToDelete.getName() + " (id = " + selectedJobDtoToDelete.getId() + " ) a été supprimé");
                    } else {
                        System.out.println("Le poste n'a pas été supprimé");
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

