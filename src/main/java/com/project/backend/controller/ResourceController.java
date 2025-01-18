package com.project.backend.controller;

import com.project.backend.dto.ResourceDTO;
import com.project.backend.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
@CrossOrigin
public class ResourceController {

    @Autowired // dependency injection
    private ResourceService resourceService;

    @GetMapping
    public List<ResourceDTO> listAll() {
        return resourceService.ListAll();
    }

    @GetMapping("/{id}")
    public ResourceDTO listResourceById(@PathVariable("id") Long id) {
        return resourceService.listResourceById(id);
    }

    @PostMapping
    public void createResource(@RequestBody ResourceDTO resourceDTO) {
        resourceService.createResource(resourceDTO);
    }

    @PutMapping
    public ResourceDTO updateResource(@RequestBody ResourceDTO resourceDTO) {
        return resourceService.updateResource(resourceDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable("id") Long id) {
        resourceService.deleteResource(id);
        return ResponseEntity.ok().build();
    }

}
