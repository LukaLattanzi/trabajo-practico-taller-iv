package com.talleriv.backend.controller;

import com.talleriv.backend.models.Staff;
import com.talleriv.backend.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping
    public List<Staff> getAll() {
        return staffService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Staff> getById(@PathVariable Long id) {
        return staffService.getById(id);
    }

    @PostMapping
    public Staff create(@RequestBody Staff staff) {
        return staffService.create(staff);
    }

    @PutMapping("/{id}")
    public Staff update(@PathVariable Long id, @RequestBody Staff staff) {
        return staffService.update(id, staff);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        staffService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        staffService.deleteAll();
    }
}