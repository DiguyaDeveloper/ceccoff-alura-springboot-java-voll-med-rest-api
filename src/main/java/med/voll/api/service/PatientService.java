package med.voll.api.service;

import med.voll.api.domain.patient.Patient;
import med.voll.api.domain.patient.PatientEntity;
import med.voll.api.domain.patient.PatientResponse;
import med.voll.api.domain.patient.UpdatePatient;
import med.voll.api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public void create(Patient patient) {
        PatientEntity newPatient = new PatientEntity(patient);
        patientRepository.save(newPatient);
    }

    public Page<PatientResponse> getAllDoctors(Pageable pagination) {
        return patientRepository.findAllByActiveTrue(pagination).map(PatientResponse::new);
    }

    public PatientResponse get(UUID id) {
        var patient = patientRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Patient not found"));
        return new PatientResponse(
            patient
        );
    }

    @Transactional
    public PatientEntity update(UUID id, UpdatePatient request) {
        var patient = patientRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Patient not found"));
        patient.update(request);

        return patient;
    }

    @Transactional
    public void delete(UUID id) {
        patientRepository.deleteById(id);
    }

    @Transactional
    public void inactivate(UUID id) {
        var doctor = patientRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Patient not found"));

        doctor.inactivate();
    }
}
