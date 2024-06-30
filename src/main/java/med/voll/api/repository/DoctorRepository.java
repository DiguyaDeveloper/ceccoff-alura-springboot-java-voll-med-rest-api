package med.voll.api.repository;

import med.voll.api.domain.doctor.DoctorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<DoctorEntity, UUID> {

    Page<DoctorEntity> findAllByActiveTrue(Pageable pageable);
}
