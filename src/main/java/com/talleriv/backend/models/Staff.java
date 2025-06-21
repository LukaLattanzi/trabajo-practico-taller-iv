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
@Table(name = "staff")
@PrimaryKeyJoinColumn(name = "person_id")
public class Staff extends Person {

    private LocalDate joined;

    @ElementCollection
    @CollectionTable(name = "staff_education", joinColumns = @JoinColumn(name = "staff_id"))
    @Column(name = "education")
    private List<String> education;

    @ElementCollection
    @CollectionTable(name = "staff_certification", joinColumns = @JoinColumn(name = "staff_id"))
    @Column(name = "certification")
    private List<String> certification;

    @ElementCollection
    @CollectionTable(name = "staff_languages", joinColumns = @JoinColumn(name = "staff_id"))
    @Column(name = "language")
    private List<String> languages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}