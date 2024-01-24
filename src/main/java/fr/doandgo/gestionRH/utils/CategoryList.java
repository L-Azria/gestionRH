package fr.doandgo.gestionRH.utils;

import fr.doandgo.gestionRH.enums.Category;
import fr.doandgo.gestionRH.enums.Service;

import java.util.Scanner;

public class CategoryList {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayCategories() {
        for (Category cat : Category.values()) {
            System.out.println(cat.ordinal() + 1 + ". " + cat.name());
        }
    }


    public static Category chooseCategory() {
        int choixCategory = scanner.nextInt();
        scanner.nextLine();

        if (choixCategory >= 1 && choixCategory <= Category.values().length) {
            Category selectedCategory = Category.values()[choixCategory - 1];
            System.out.println("Vous avez choisi la catégorie : " + selectedCategory.name());
            return selectedCategory;

        } else {
            System.out.println("Choix de catégorie non valide.");
            return null;
        }
    }
}
