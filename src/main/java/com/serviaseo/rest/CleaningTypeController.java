package com.serviaseo.rest;

import com.serviaseo.model.CleaningType;
import com.serviaseo.service.CleaningTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cleaning-types")
public class CleaningTypeController {

    @Autowired
    private CleaningTypeService cleaningTypeService;

    @GetMapping
    public List<CleaningType> getAllCleaningTypes() {
        return cleaningTypeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CleaningType> getCleaningTypeById(@PathVariable Long id) {
        Optional<CleaningType> cleaningType = cleaningTypeService.findById(id);
        return cleaningType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CleaningType createCleaningType(@RequestBody CleaningType cleaningType) {
        return cleaningTypeService.save(cleaningType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCleaningType(@PathVariable Long id) {
        cleaningTypeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
