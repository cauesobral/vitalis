package com.cauesobral.vitalis.service.impl;

import com.cauesobral.vitalis.repository.TriageRepository;
import org.springframework.stereotype.Service;

@Service
public class TriageService {

    private final TriageRepository triageRepository;

    public TriageService(TriageRepository triageRepository) {
        this.triageRepository = triageRepository;
    }

}
