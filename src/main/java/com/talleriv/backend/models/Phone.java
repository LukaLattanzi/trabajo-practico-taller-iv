package com.talleriv.backend.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Phone {
    private String countryCode; // ej. "+54"
    private String number; // ej. "123456789"
    private String extension; // opcional, puede quedar nulo
}
