package com.talleriv.backend.controller;

import com.talleriv.backend.models.Department;
import com.talleriv.backend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Department> getById(@PathVariable Long id) {
        return departmentService.getById(id);
    }

    @PostMapping
    public Department create(@RequestBody Department department) {
        return departmentService.create(department);
    }

    @PutMapping("/{id}")
    public Department update(@PathVariable Long id, @RequestBody Department department) {
        return departmentService.update(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        departmentService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        departmentService.deleteAll();
    }
}