package com.cauesobral.vitalis.repository;

import com.cauesobral.vitalis.model.Triage;
import com.cauesobral.vitalis.model.TriageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TriageRepository extends JpaRepository<Triage, Long> {
    List<Triage> findByStatusOrderByPriorityDescIdAsc(TriageStatus status);
    Optional<Triage> findByAppointmentId(Long appointmentId);
    @Query("""
    SELECT t FROM Triage t
    WHERE t.status IN :statuses
    ORDER BY t.priority DESC, t.id ASC
""")
    List<Triage> findQueue(@Param("statuses") List<TriageStatus> statuses);
}
