package med.voll.api.controller;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import med.voll.api.domain.doctor.*;
import med.voll.api.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.print.Doc;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @PostMapping
    public ResponseEntity<DoctorResponse> create(@RequestBody @Valid Doctor request, UriComponentsBuilder uriBuilder) {
        DoctorEntity doctor = doctorService.create(request);

        var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DoctorResponse(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorResponse>> getAll(@PageableDefault(size = 10, page = 0, sort = {"name"}) Pageable pagination) {
        Page<DoctorResponse> doctors =  doctorService.getAllDoctors(pagination);

        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/{id}")
    public DoctorResponse get(@PathVariable("id") UUID id) {
        return doctorService.get(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponse> update(@PathVariable("id") UUID id, @RequestBody UpdateDoctor request) {
        DoctorEntity doctor = doctorService.update(id, request);

        return ResponseEntity.ok(new DoctorResponse(doctor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") UUID id) {
        doctorService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/inactive")
    public ResponseEntity inactive(@PathVariable("id") UUID id) {
        doctorService.inactivate(id);

        return ResponseEntity.noContent().build();
    }
}
