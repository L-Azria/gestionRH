package fr.doandgo.gestionRH.utils;

import fr.doandgo.gestionRH.dto.JobDto;

import java.util.List;
import java.util.Scanner;

public class JobList {
    private Scanner scanner;

    public JobList(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayJob(List<JobDto> jobDtoList) {
        for (JobDto j : jobDtoList) {
            System.out.println(j);
        }
    }

    public JobDto selectJob(List<JobDto> jobDtoList) {
        int selectedJobId = scanner.nextInt();
        scanner.nextLine();


        for (JobDto j : jobDtoList) {
            if (j.getId() == selectedJobId) {
                return j;
            }
        }

        return null;
    }
}
