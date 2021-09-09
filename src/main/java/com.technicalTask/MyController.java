package com.technicalTask;

import com.technicalTask.model.Patient;
import com.technicalTask.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    private final PatientRepository patientRepository;

    @Autowired
    public MyController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/add")
    public String addPatient(Model model) {
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients", patients);
        return "add";
    }

    @PostMapping("/add")
    public String add(@RequestParam String fio,
                      @RequestParam String passport,
                      @RequestParam String dateOfBirth,
                      @RequestParam char gender,
                      Model model) {
        Patient patient = new Patient(fio, passport, dateOfBirth, gender);
        patientRepository.save(patient);

        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients", patients);
        return "redirect:/";

    }

    @GetMapping("/search")
    public String search(Model model) {
        List<Patient> patient = patientRepository.findAll();
        model.addAttribute("patient", patient);
        return "search";
    }

    @PostMapping("/search")
    public String searchPatient(@RequestParam String fio, @RequestParam String passport, Model model) {
        List<Patient> patient;

        if (fio != null && passport != null) {
            patient = patientRepository.findPatientByFioAndPassport(fio, passport);
        } else {
            patient = patientRepository.findAll();
        }
        model.addAttribute("patient", patient);
        return "search";
    }
}
