package fr.doandgo.gestionRH.utils;

import fr.doandgo.gestionRH.dto.EmployeeDto;

import java.util.List;
import java.util.Scanner;

public class EmployeeList {
    private Scanner scanner;

    public EmployeeList(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayEmployee(List<EmployeeDto> employeeDtoList) {
        for (EmployeeDto e : employeeDtoList) {
            System.out.println(e);
        }
    }

    public EmployeeDto selectEmployee(List<EmployeeDto> emplyeeDtoList) {
        int selectedEmployeeId = scanner.nextInt();
        scanner.nextLine();


        for (EmployeeDto e : emplyeeDtoList) {
            if (e.getId() == selectedEmployeeId) {
                return e;
            }
        }

        return null;
    }
}
