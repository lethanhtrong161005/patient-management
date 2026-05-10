package com.pm.patientservice.dto.request;

import java.time.Instant;
import java.time.LocalDate;

import com.pm.patientservice.vadidators.CreatePatientValidatorGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PatientRequestDTO {
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be less than 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    @NotNull(message = "Date of Birth is required")
    private Instant dateOfBirth;

    @NotNull(groups = CreatePatientValidatorGroup.class, message = "Registered Date is required")
    private Instant registeredDate;

    public Instant getRegisteredDate() {
        return registeredDate;
    }


    public void setRegisteredDate(Instant registeredDate) {
        this.registeredDate = registeredDate;
    }

}
