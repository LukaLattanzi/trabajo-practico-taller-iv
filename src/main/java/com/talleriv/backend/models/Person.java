package com.talleriv.backend.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import lombok.experimental.SuperBuilder;

import com.talleriv.backend.enums.Gender;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "persons") // nombre de tabla base
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // ej. "Sr.", "Sra.", "Dr.", etc.

    private String firstName;
    private String lastName;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street")),
            @AttributeOverride(name = "city", column = @Column(name = "home_city")),
            @AttributeOverride(name = "state", column = @Column(name = "home_state")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "home_postal_code")),
            @AttributeOverride(name = "country", column = @Column(name = "home_country"))
    })
    private Address homeAddress;

    private String phone; // telefono libre como String
}
