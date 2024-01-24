package fr.doandgo.gestionRH.controller;

import fr.doandgo.gestionRH.dto.JobDto;
import fr.doandgo.gestionRH.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
@AllArgsConstructor
public class JobController extends AbstractController<JobDto> {

    private JobService jobService;
    @Override
    protected JobDto getDtoById(Integer id) {
        return null;
    }

    @Override
    public List<JobDto> getAllDto() {
        return null;
    }

    public List<JobDto> getAllDtoByCompagny(String nameCompagny) {
        return this.jobService.findAllJobByCompagny(nameCompagny);
    }

    @Override
    @Transactional
    public void createDto(JobDto dto) {
        this.jobService.createJob(dto);
    }

    @Override
    public void updateDto(Integer id, JobDto dto) {
        this.jobService.updateJob(id, dto);

    }

    @Override
    public void deleteDto(Integer id) {
        this.jobService.deleteJob(id);

    }
}
