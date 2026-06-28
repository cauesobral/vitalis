package com.cauesobral.vitalis.repository;

import com.cauesobral.vitalis.model.Triage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TriageRepository extends JpaRepository<Triage, Long> {

    Optional<Triage> findByAppointmentId(Long appointmentId);
}
