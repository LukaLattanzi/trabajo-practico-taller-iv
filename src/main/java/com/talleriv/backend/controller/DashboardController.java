package com.talleriv.backend.controller;

import com.talleriv.backend.service.DepartmentService;
import com.talleriv.backend.service.HospitalService;
import com.talleriv.backend.service.PatientService;
import com.talleriv.backend.service.StaffService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private StaffService staffService;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("departments", departmentService.getAll());
        model.addAttribute("hospitals", hospitalService.getAll());
        model.addAttribute("patients", patientService.getAll());
        model.addAttribute("staff", staffService.getAll());

        // Consultas nativas para las tablas de colecciones
        model.addAttribute("staffEducation",
                entityManager.createNativeQuery("SELECT * FROM staff_education").getResultList());
        model.addAttribute("staffCertification",
                entityManager.createNativeQuery("SELECT * FROM staff_certification").getResultList());
        model.addAttribute("staffLanguages",
                entityManager.createNativeQuery("SELECT * FROM staff_languages").getResultList());
        model.addAttribute("patientPrescriptions",
                entityManager.createNativeQuery("SELECT * FROM patient_prescriptions").getResultList());
        model.addAttribute("patientAllergies",
                entityManager.createNativeQuery("SELECT * FROM patient_allergies").getResultList());
        model.addAttribute("patientSpecialReqs",
                entityManager.createNativeQuery("SELECT * FROM patient_special_reqs").getResultList());

        return "dashboard";
    }
}