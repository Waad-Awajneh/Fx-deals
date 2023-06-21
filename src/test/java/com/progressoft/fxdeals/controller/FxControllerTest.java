package com.progressoft.fxdeals.controller;

import com.progressoft.fxdeals.mapper.DealMapper;
import com.progressoft.fxdeals.model.DealEntity;
import com.progressoft.fxdeals.repository.FxRepository;
import com.progressoft.fxdeals.resource.DealResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FxControllerTest {
    @Mock
    private FxRepository fxRepository;
    @Spy
    private DealMapper mapper;
    @InjectMocks
    private FxController fxController;

    @Test
    void saveFxDeals() {
        DealResource dealResource = new DealResource();
        dealResource.setAmount(1.0);
        dealResource.setDateTime(LocalDateTime.now());
        dealResource.setOrderingCurrency("123");
        dealResource.setCodeCurrency("JOD");

        when(fxRepository.save(any(DealEntity.class))).thenReturn(new DealEntity());
        fxController.saveFxDeals(dealResource);
    }

    @Test
    void requestEntities() {


        DealEntity dealEntity = new DealEntity();
        dealEntity.setAmount(1.0);
        dealEntity.setOrderingCurrency("123");
        dealEntity.setCodeCurrency("JOD");
        dealEntity.setDateTime(LocalDateTime.now());
        when(fxRepository.findAll()).thenReturn(List.of(dealEntity));
        List<DealResource> dealResources = fxController.requestEntities();
        Assertions.assertNotNull(dealResources);

    }

}