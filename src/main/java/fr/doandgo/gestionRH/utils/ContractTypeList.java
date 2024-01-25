package fr.doandgo.gestionRH.utils;

import fr.doandgo.gestionRH.enums.ContractTypes;

import java.util.Scanner;

public class ContractTypeList {

    private static Scanner scanner = new Scanner(System.in);

    public static void displayContractType() {
        for (ContractTypes ct : ContractTypes.values()) {
            System.out.println(ct.ordinal() + 1 + ". " + ct.name());
        }
    }


    public static ContractTypes chooseContractTypes() {
        int choixContractTypes = scanner.nextInt();
        scanner.nextLine();

        if (choixContractTypes >= 1 && choixContractTypes <= ContractTypes.values().length) {
            ContractTypes selectedContractTypes = ContractTypes.values()[choixContractTypes - 1];
            System.out.println("Vous avez choisi la catégorie : " + selectedContractTypes.name());
            return selectedContractTypes;

        } else {
            System.out.println("Choix de contrat non valide.");
            return null;
        }
    }
}
