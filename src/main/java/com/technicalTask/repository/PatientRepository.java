package com.technicalTask.repository;

import com.technicalTask.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findPatientByFioAndPassport(String fio, String passport);

}
