package com.serviaseo.ports.input;

import com.serviaseo.core.domain.CleaningType;

import java.util.List;

public interface CleaningTypeUseCase {
    List<CleaningType> listCleaningTypes();
    CleaningType addCleaningType(CleaningType cleaningType);
}