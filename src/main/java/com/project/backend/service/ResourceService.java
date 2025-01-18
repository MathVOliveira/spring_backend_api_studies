package com.project.backend.service;

import com.project.backend.dto.ResourceDTO;
import com.project.backend.entities.ResourceEntity;
import com.project.backend.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    @Autowired // dependency injection
    private ResourceRepository resourceRepository;

    // Read
    public List<ResourceDTO> ListAll() {
        // the return of the Repository is an Entity
        List<ResourceEntity> resources = resourceRepository.findAll();
        return resources.stream().map(ResourceDTO::new).toList();
    }

    // Create
    public void createResource(ResourceDTO resourceDTO) {
        ResourceEntity resourceEntity = new ResourceEntity(resourceDTO);
        resourceRepository.save(resourceEntity);
    }

    // Update
    public ResourceDTO updateResource(ResourceDTO resourceDTO) {
        ResourceEntity resourceEntity = new ResourceEntity(resourceDTO);
        return new ResourceDTO(resourceRepository.save(resourceEntity));
    }

    // Delete
    public void deleteResource(Long id) {
        // find the resource before deleting
        ResourceEntity resourceEntity = resourceRepository.findById(id).get();
        resourceRepository.delete(resourceEntity);
    }

    // Find by id
    public ResourceDTO listResourceById(Long id) {
        return new ResourceDTO(resourceRepository.findById(id).get());
    }
}
