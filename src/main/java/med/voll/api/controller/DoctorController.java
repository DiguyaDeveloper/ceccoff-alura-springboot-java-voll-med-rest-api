package med.voll.api.controller;

import med.voll.api.domain.doctor.Doctor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @PostMapping
    public void create(@RequestBody Doctor request) {

    }

}
