package com.progressoft.fxdeals.mapper;

import com.progressoft.fxdeals.exceptionhandler.FxDealValidationException;
import com.progressoft.fxdeals.model.DealEntity;
import com.progressoft.fxdeals.resource.DealResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DealMapperTest {
private  final DealMapper dealMapper= new DealMapper();
    @Test
    void toDealEntity() {


        DealResource dealResource = new DealResource();
        dealResource.setAmount(1.0);
        dealResource.setDateTime(LocalDateTime.now());
        dealResource.setOrderingCurrency("123");
        dealResource.setCodeCurrency("JOD");

        DealEntity dealEntity = dealMapper.toDealEntity(dealResource);
        Assertions.assertEquals(dealEntity.getAmount(), 1.0);
        Assertions.assertNotNull(dealEntity.getDateTime());
        Assertions.assertEquals(dealEntity.getCodeCurrency(),"JOD");
        Assertions.assertEquals(dealEntity.getOrderingCurrency(),"123");
    }




    @Test
    void toDealResource() {


        DealEntity dealEntity = new DealEntity();
        dealEntity.setAmount(1.0);
        dealEntity.setOrderingCurrency("123");
        dealEntity.setCodeCurrency("JOD");
        dealEntity.setDateTime(LocalDateTime.now());

        DealResource dealResource = dealMapper.toDealResource(dealEntity);
        Assertions.assertEquals(dealResource.getAmount(), 1.0);
        Assertions.assertNotNull(dealResource.getDateTime());
        Assertions.assertEquals(dealResource.getCodeCurrency(),"JOD");
        Assertions.assertEquals(dealResource.getOrderingCurrency(),"123");
    }

    @Test
    void invalidCases() {


        DealResource dealResource = new DealResource();
        dealResource.setAmount(-1.0);
        dealResource.setOrderingCurrency("");
        dealResource.setCodeCurrency("");

        FxDealValidationException fxDealValidationException = assertThrows(FxDealValidationException.class, () -> dealMapper.toDealEntity(dealResource));
Assertions.assertNotNull(fxDealValidationException.getErrors());
Assertions.assertEquals(fxDealValidationException.getErrors().get("amount"),"Amount is negative");
    }
}