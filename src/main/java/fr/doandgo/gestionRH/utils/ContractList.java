package fr.doandgo.gestionRH.utils;

import fr.doandgo.gestionRH.dto.ContractDto;
import fr.doandgo.gestionRH.dto.EmployeeDto;

import java.util.List;
import java.util.Scanner;

public class ContractList {
    private Scanner scanner;

    public ContractList(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayContract(List<ContractDto> contractDtoList) {
        for (ContractDto c : contractDtoList) {
            System.out.println(c);
        }
    }

    public ContractDto selectContract(List<ContractDto> contractDtoList) {
        int selectedContractId = scanner.nextInt();
        scanner.nextLine();


        for (ContractDto c : contractDtoList) {
            if (c.getId() == selectedContractId) {
                return c;
            }
        }

        return null;
    }
}
