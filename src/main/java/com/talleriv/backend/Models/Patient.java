package com.talleriv.backend.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Patient extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;
    private LocalDate accepted;

    @ElementCollection
    private List<String> prescriptions;

    @ElementCollection
    private List<String> allergies;

    @ElementCollection
    private List<String> specialReqs;
}
