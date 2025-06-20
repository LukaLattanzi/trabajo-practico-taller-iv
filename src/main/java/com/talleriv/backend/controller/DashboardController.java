package com.talleriv.backend.controller;

import com.talleriv.backend.service.DepartmentService;
import com.talleriv.backend.service.HospitalService;
import com.talleriv.backend.service.PatientService;
import com.talleriv.backend.service.StaffService;
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

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("departments", departmentService.getAll());
        model.addAttribute("hospitals", hospitalService.getAll());
        model.addAttribute("patients", patientService.getAll());
        model.addAttribute("staff", staffService.getAll());
        return "dashboard";
    }
}