package fr.doandgo.gestionRH.service;

import fr.doandgo.gestionRH.dto.JobDto;
import fr.doandgo.gestionRH.entity.Compagny;
import fr.doandgo.gestionRH.entity.Job;
import fr.doandgo.gestionRH.repository.CompagnyRepository;
import fr.doandgo.gestionRH.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class JobService {

    private JobRepository jobRepository;
    private CompagnyRepository compagnyRepository;

    public List<JobDto> findAllJob(){
        List<Job> jobList = this.jobRepository.findAll();
        List<JobDto> jobDtoList = new ArrayList<>();
        for(Job j : jobList){
            jobDtoList.add((j.toJobDto(j)));
        }
        return jobDtoList;
    }

    public List<JobDto> findAllJobByCompagny(String nameCompagny){
        Optional<Compagny> optionalCompagny = this.compagnyRepository.findCompagnyByName(nameCompagny);
        if(optionalCompagny.isPresent()) {
            Compagny existingCompagny = optionalCompagny.get();
            List<Job> jobList = jobRepository.findJobsByCompagny(existingCompagny);
            List<JobDto> jobDtoList = new ArrayList<>();
            if (!jobList.isEmpty()) {
                for (Job j : jobList) {
                    jobDtoList.add(j.toJobDto(j));
                }
                return jobDtoList;
            } else {
                System.out.println("La compagnie n'a pas de poste");
            }

        } else {
            System.out.println("Le nom de la compagnie n'est pas valable");
        }
        return null;


    }

    @Transactional
    public void createJob(JobDto dto){
        Job newJob = new Job(dto.getName(), dto.getService(), dto.getCategory(), dto.getCompagny().toCompagny());
         jobRepository.save(newJob);
    }

    public void updateJob (Integer id, JobDto dto){
        Optional<Job> optionalJob = this.jobRepository.findById(id);
        if (optionalJob.isPresent()) {
            Job existingJob = optionalJob.get();

            // Update the Job with the new value from the DTO
            existingJob.setName(dto.getName());
            existingJob.setService(dto.getService());
            existingJob.setCategory(dto.getCategory());


            // Save the updated entity back to the repository
            this.jobRepository.save(existingJob);
        } else {
            System.out.println("Le poste avec ID " + id + " non trouvé.");
        }

    }

    public void deleteJob (Integer id){
        this.jobRepository.deleteById(id);
    }




}




