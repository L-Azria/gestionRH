package fr.doandgo.gestionRH.utils;

import fr.doandgo.gestionRH.enums.Service;

import java.util.Scanner;

public class ServiceList {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayServices() {
        for (Service service : Service.values()) {
            System.out.println(service.ordinal() + 1 + ". " + service.name());
        }
    }

    public static Service chooseService() {
        int choixService = scanner.nextInt();
        scanner.nextLine();

        if (choixService >= 1 && choixService <= Service.values().length) {
            Service selectedService = Service.values()[choixService - 1];
            System.out.println("Vous avez choisi le service : " + selectedService.name());
            return selectedService;

        } else {
            System.out.println("Choix de service non valide.");
            return null;
        }
    }
}
