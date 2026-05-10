package com.pm.patientservice.controller;


import com.pm.patientservice.dto.request.PatientRequestDTO;
import com.pm.patientservice.service.PatientService;

import com.pm.patientservice.vadidators.CreatePatientValidatorGroup;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
@Tag(name = "Patient", description = "API for managing Patients")
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    @Operation(summary = "Get Patients")
    public ResponseEntity<?> getPatients() {
        return ResponseEntity.ok(patientService.getPatients());
    }

    @PostMapping
    @Operation(summary = "Create a new Patient")
    public ResponseEntity<?> createPatient(
        @RequestBody @Validated ({
        Builder.Default.class, CreatePatientValidatorGroup.class
    }) PatientRequestDTO patientRequestDTO) {
        return ResponseEntity.ok(patientService.createPatient(patientRequestDTO));
    }

    //localhost:4000/patients/1232131-21321312-2131231
    @PutMapping("/{id}")
    @Operation(summary = "Update Patient")
    public ResponseEntity<?> updatePatient(
        @RequestBody
        @Validated({Builder.Default.class}) PatientRequestDTO patientRequestDTO, @PathVariable UUID id) {
        return ResponseEntity.ok(patientService.updatePatient(id, patientRequestDTO));
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete patient")
    public ResponseEntity<?> deletePatient(@PathVariable UUID id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}
