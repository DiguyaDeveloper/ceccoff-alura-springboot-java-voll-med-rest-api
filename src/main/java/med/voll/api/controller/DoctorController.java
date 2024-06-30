package med.voll.api.controller;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import med.voll.api.domain.doctor.Doctor;
import med.voll.api.domain.doctor.DoctorEntity;
import med.voll.api.domain.doctor.DoctorResponse;
import med.voll.api.domain.doctor.UpdateDoctor;
import med.voll.api.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public DoctorResponse get(@PathVariable("id") UUID id) {
        return doctorService.get(id);
    }

    @PutMapping("/{id}")
    public DoctorEntity update(@PathVariable("id") UUID id, @RequestBody UpdateDoctor request) {
        return doctorService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        doctorService.delete(id);
    }

    @DeleteMapping("/{id}/inactive")
    public void inactive(@PathVariable("id") UUID id) {
        doctorService.inactivate(id);
    }
}
