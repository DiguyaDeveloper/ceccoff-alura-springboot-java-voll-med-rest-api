package med.voll.api.repository;

import med.voll.api.domain.patient.PatientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<PatientEntity, UUID> {

    Page<PatientEntity> findAllByActiveTrue(Pageable pageable);
}
