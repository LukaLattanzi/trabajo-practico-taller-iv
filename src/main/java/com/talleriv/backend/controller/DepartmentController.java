package com.talleriv.backend.controller;

import com.talleriv.backend.models.Department;
import com.talleriv.backend.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Department> getById(@PathVariable Long id) {
        return departmentRepository.findById(id);
    }

    @PostMapping
    public Department create(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @PutMapping("/{id}")
    public Department update(@PathVariable Long id, @RequestBody Department department) {
        department.setId(id);
        return departmentRepository.save(department);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        departmentRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        departmentRepository.deleteAll();
    }
}