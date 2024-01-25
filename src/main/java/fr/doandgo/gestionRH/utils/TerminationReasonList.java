package fr.doandgo.gestionRH.utils;

import fr.doandgo.gestionRH.enums.Category;
import fr.doandgo.gestionRH.enums.TerminationReason;

import java.util.Scanner;

public class TerminationReasonList {


    private static Scanner scanner = new Scanner(System.in);

    public static void displayTerminationReason() {
        for (TerminationReason tr : TerminationReason.values()) {
            System.out.println(tr.ordinal() + 1 + ". " + tr.name());
        }
    }


    public static TerminationReason chooseTerminationReason() {
        int choixTerminationReason = scanner.nextInt();
        scanner.nextLine();

        if (choixTerminationReason >= 1 && choixTerminationReason <= TerminationReason.values().length) {
            TerminationReason selectedTerminationReason = TerminationReason.values()[choixTerminationReason - 1];
            System.out.println("Vous avez choisi la raison : " + selectedTerminationReason.name());
            return selectedTerminationReason;

        } else {
            System.out.println("Choix de contrat non valide.");
            return null;
        }
    }
}
