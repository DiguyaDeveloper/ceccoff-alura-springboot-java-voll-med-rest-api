package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.doctor.Doctor;
import med.voll.api.domain.doctor.DoctorEntity;
import med.voll.api.domain.doctor.DoctorResponse;
import med.voll.api.domain.doctor.UpdateDoctor;
import med.voll.api.domain.patient.Patient;
import med.voll.api.domain.patient.PatientEntity;
import med.voll.api.domain.patient.PatientResponse;
import med.voll.api.domain.patient.UpdatePatient;
import med.voll.api.service.DoctorService;
import med.voll.api.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @PostMapping
    public void create(@RequestBody @Valid Patient request) {
        patientService.create(request);
    }

    @GetMapping
    public Page<PatientResponse> getAll(@PageableDefault(size = 10, page = 0, sort = {"name"}) Pageable pagination) {
        return patientService.getAllDoctors(pagination);
    }

    @GetMapping("/{id}")
    public PatientResponse get(@PathVariable("id") UUID id) {
        return patientService.get(id);
    }

    @PutMapping("/{id}")
    public PatientEntity update(@PathVariable("id") UUID id, @RequestBody UpdatePatient request) {
        return patientService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        patientService.delete(id);
    }

    @DeleteMapping("/{id}/inactive")
    public void inactive(@PathVariable("id") UUID id) {
        patientService.inactivate(id);
    }
}
