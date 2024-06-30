package med.voll.api.service;

import med.voll.api.domain.address.AddressEntity;
import med.voll.api.domain.doctor.Doctor;
import med.voll.api.domain.doctor.DoctorEntity;
import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public void create(Doctor doctor) {
        DoctorEntity newDoctor = new DoctorEntity(doctor);
        doctorRepository.save(newDoctor);
    }
}
