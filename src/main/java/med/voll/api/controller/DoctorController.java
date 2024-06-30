package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.doctor.Doctor;
import med.voll.api.domain.doctor.DoctorResponse;
import med.voll.api.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @PostMapping
    public void create(@RequestBody @Valid Doctor request) {
        doctorService.create(request);
    }

    @GetMapping
    public Page<DoctorResponse> getAll(@PageableDefault(size = 10, page = 0, sort = {"name"}) Pageable pagination) {
        return doctorService.getAllDoctors(pagination);
    }
}
