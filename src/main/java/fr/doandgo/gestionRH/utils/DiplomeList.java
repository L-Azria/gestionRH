package fr.doandgo.gestionRH.utils;

import fr.doandgo.gestionRH.enums.Diplome;
import fr.doandgo.gestionRH.enums.Service;

import java.util.Scanner;

public class DiplomeList {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayDiplome() {
        for (Diplome diplome : Diplome.values()) {
            System.out.println(diplome.ordinal() + 1 + ". " + diplome.name());
        }
    }

    public static Diplome chooseDiplome() {
        int choixDiplome = scanner.nextInt();
        scanner.nextLine();

        if (choixDiplome >= 1 && choixDiplome <= Diplome.values().length) {
            Diplome selectedDiplome = Diplome.values()[choixDiplome - 1];
            System.out.println("Vous avez choisi le diplôme : " + selectedDiplome.name());
            return selectedDiplome;

        } else {
            System.out.println("Choix de diplôme non valide.");
            return null;
        }
    }
}
