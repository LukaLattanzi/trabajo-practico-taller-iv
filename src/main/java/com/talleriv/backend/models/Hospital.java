package com.talleriv.backend.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hospitals")
public class Hospital {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @Embedded
        @AttributeOverrides({
                        @AttributeOverride(name = "street", column = @Column(name = "address_street")),
                        @AttributeOverride(name = "city", column = @Column(name = "address_city")),
                        @AttributeOverride(name = "state", column = @Column(name = "address_state")),
                        @AttributeOverride(name = "postalCode", column = @Column(name = "address_postal_code")),
                        @AttributeOverride(name = "country", column = @Column(name = "address_country"))
        })
        private Address address;

        @Embedded
        @AttributeOverrides({
                        @AttributeOverride(name = "countryCode", column = @Column(name = "phone_country_code")),
                        @AttributeOverride(name = "number", column = @Column(name = "phone_number")),
                        @AttributeOverride(name = "extension", column = @Column(name = "phone_extension"))
        })
        private Phone phone;

        // Composición: Hospital tiene muchos departamentos
        @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
        @Builder.Default
        private Set<Department> departments = new HashSet<>();

        // Relación inversa desde Patient
        @OneToMany(mappedBy = "hospital")
        @Builder.Default
        private Set<Patient> patients = new HashSet<>();
}