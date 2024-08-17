package com.serviaseo.ports.output;

import com.serviaseo.core.domain.CleaningType;

import java.util.List;
import java.util.Optional;

public interface CleaningTypeRepository {
    CleaningType save(CleaningType cleaningType);
    List<CleaningType> findAll();
    Optional<CleaningType> findById(Long id);
}