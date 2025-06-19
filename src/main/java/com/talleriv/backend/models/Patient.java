package com.talleriv.backend.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "patients")
@PrimaryKeyJoinColumn(name = "person_id") // FK a persons.id
public class Patient extends Person {

    private Integer age; // aunque se podría derivar de birthDate, lo incluimos según UML

    private LocalDate accepted; // fecha de aceptación/ingreso

    @ElementCollection
    @CollectionTable(name = "patient_prescriptions", joinColumns = @JoinColumn(name = "patient_id"))
    @Column(name = "prescription")
    private List<String> prescriptions;

    @ElementCollection
    @CollectionTable(name = "patient_allergies", joinColumns = @JoinColumn(name = "patient_id"))
    @Column(name = "allergy")
    private List<String> allergies;

    @ElementCollection
    @CollectionTable(name = "patient_special_reqs", joinColumns = @JoinColumn(name = "patient_id"))
    @Column(name = "special_req")
    private List<String> specialReqs;

    // Relación con Hospital (opcional según interpretación):
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
