package med.voll.api.service;

import med.voll.api.domain.doctor.Doctor;
import med.voll.api.domain.doctor.DoctorEntity;
import med.voll.api.domain.doctor.DoctorResponse;
import med.voll.api.domain.doctor.UpdateDoctor;
import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public void create(Doctor doctor) {
        DoctorEntity newDoctor = new DoctorEntity(doctor);
        doctorRepository.save(newDoctor);
    }

    public Page<DoctorResponse> getAllDoctors(Pageable pagination) {
        return doctorRepository.findAllByActiveTrue(pagination).map(DoctorResponse::new);
    }

    public DoctorResponse get(UUID id) {
        var doctor = doctorRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Doctor not found"));
        return new DoctorResponse(
            doctor
        );
    }

    @Transactional
    public DoctorEntity update(UUID id, UpdateDoctor request) {
        var doctor = doctorRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Doctor not found"));
        doctor.update(request);

        return doctor;
    }

    @Transactional
    public void delete(UUID id) {
        doctorRepository.deleteById(id);
    }

    @Transactional
    public void inactivate(UUID id) {
        var doctor = doctorRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Doctor not found"));

        doctor.inactivate();
    }
}
