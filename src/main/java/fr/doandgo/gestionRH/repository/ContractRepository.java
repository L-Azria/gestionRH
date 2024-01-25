package fr.doandgo.gestionRH.repository;

import fr.doandgo.gestionRH.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    List<Contract> findContractsByEmployee_Id(Integer employeeId);
}
