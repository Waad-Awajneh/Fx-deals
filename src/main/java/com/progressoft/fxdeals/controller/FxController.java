package com.progressoft.fxdeals.controller;

import com.progressoft.fxdeals.mapper.DealMapper;
import com.progressoft.fxdeals.repository.FxRepository;
import com.progressoft.fxdeals.resource.DealResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/")
@Slf4j

public class FxController {

    private final FxRepository fxRepository;
    private final DealMapper mapper;

    public FxController(FxRepository fxRepository, DealMapper mapper) {
        this.fxRepository = fxRepository;
        this.mapper = mapper;
    }

    @PostMapping()
    public void saveFxDeals(@RequestBody DealResource dealResource) {
        fxRepository.save(mapper.toDealEntity(dealResource));
        log.info("transaction saved with");
    }

    @GetMapping
    public List<DealResource> requestEntities() {
        log.info("get all transactions");
        return fxRepository
                .findAll()
                .stream()
                .map(mapper::toDealResource)
                .collect(Collectors.toList());
    }
}
