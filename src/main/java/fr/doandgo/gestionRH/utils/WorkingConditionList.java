package fr.doandgo.gestionRH.utils;

import fr.doandgo.gestionRH.enums.WorkingCondition;

import java.util.Scanner;

public class WorkingConditionList {


    private static Scanner scanner = new Scanner(System.in);

    public static void displayWorkingCondition() {
        for (WorkingCondition w : WorkingCondition.values()) {
            System.out.println(w.ordinal() + 1 + ". " + w.name());
        }
    }


    public static WorkingCondition chooseWorkingCondition() {
        int choixWorkingCondition = scanner.nextInt();
        scanner.nextLine();

        if (choixWorkingCondition >= 1 && choixWorkingCondition <= WorkingCondition.values().length) {
            WorkingCondition selectedWorkingCondition = WorkingCondition.values()[choixWorkingCondition - 1];
            System.out.println("Vous avez choisi la catégorie : " + selectedWorkingCondition.name());
            return selectedWorkingCondition;

        } else {
            System.out.println("Choix de contrat non valide.");
            return null;
        }
    }
}
