package fr.doandgo.gestionRH.service;

import fr.doandgo.gestionRH.dto.CompagnyDto;
import fr.doandgo.gestionRH.dto.JobDto;
import fr.doandgo.gestionRH.entity.Compagny;
import fr.doandgo.gestionRH.entity.Job;
import fr.doandgo.gestionRH.repository.CompagnyRepository;
import fr.doandgo.gestionRH.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class JobService {

    private JobRepository jobRepository;
    private CompagnyRepository compagnyRepository;

    public List<JobDto> findAllJobByCompagny(String nameCompagny){
        Optional<Compagny> optionalCompagny = this.compagnyRepository.findCompagnyByName(nameCompagny);
        if(optionalCompagny.isPresent()){
            Compagny existingCompagny = optionalCompagny.get();
            List<Job> jobList = jobRepository.findJobsByCompagny(existingCompagny);
            List<JobDto> JobDtoList = new ArrayList<>();
            if(!jobList.isEmpty()){
                for (Job j : jobList){
                    JobDtoList.add(changeToJobDto(j));
                }
        }
            return JobDtoList;

        } else {
            System.out.println("La comapgnie n'a pas de postes");
        }


        return null;
    }

    public JobDto changeToJobDto(Job job){
        return new JobDto(
                job.getId(),
                job.getName(),
                job.getService(),
                job.getCategory(),
                job.getManaged(),
                job.getCompagny()
        );
    }
}
