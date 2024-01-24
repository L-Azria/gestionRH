package fr.doandgo.gestionRH.ihm;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
@AllArgsConstructor
public class ConsoleView {

    private static Scanner scanner = new Scanner(System.in);

    private DisplayMenuCompagny displayMenuCompagny;
    private DisplayMenuJob displayMenuJob;
    private DisplayMenuEmployee displayMenuEmployee;
    private DisplayMenuContract displayMenuContract;


    public void consoleView() {
        int choix;
        do {
            System.out.println("L'action que vous voulez effectuer concerne :");
            System.out.println("1. Les postes de travail");
            System.out.println("2. Les employés");
            System.out.println("3. Les compagnies");
            System.out.println("4. Les contrats");
            System.out.println("99. Exit");
            System.out.println("Choix n° : ");

            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    displayMenuJob.displayMenuJob();
                    break;
                case 2:
                    displayMenuEmployee.displayMenuEmplyee();
                    break;
                case 3:
                    displayMenuCompagny.displayMenuCompagny();
                    break;
                case 4:
                    displayMenuContract.displayMenuContract();
                    break;
                case 99:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix non valide. Veuillez réessayer.");
            }
        } while (choix != 99);
    }


}

