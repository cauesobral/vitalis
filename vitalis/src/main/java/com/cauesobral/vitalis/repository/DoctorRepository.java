package com.cauesobral.vitalis.repository;

import com.cauesobral.vitalis.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByCrm(String crm);

    boolean existsByCrm(String crm);
}
