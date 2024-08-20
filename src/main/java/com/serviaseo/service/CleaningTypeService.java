package com.serviaseo.service;

import com.serviaseo.model.CleaningType;
import com.serviaseo.repository.CleaningTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CleaningTypeService {

    @Autowired
    private CleaningTypeRepository cleaningTypeRepository;

    public List<CleaningType> findAll() {
        return cleaningTypeRepository.findAll();
    }

    public Optional<CleaningType> findById(Long id) {
        return cleaningTypeRepository.findById(id);
    }

    public CleaningType save(CleaningType cleaningType) {
        return cleaningTypeRepository.save(cleaningType);
    }

    public void deleteById(Long id) {
        cleaningTypeRepository.deleteById(id);
    }
}