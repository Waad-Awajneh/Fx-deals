package com.progressoft.fxdeals.mapper;

import com.progressoft.fxdeals.exceptionhandler.FxDealValidationException;
import com.progressoft.fxdeals.model.DealEntity;
import com.progressoft.fxdeals.resource.DealResource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class DealMapper {

    public DealEntity toDealEntity(DealResource dealResource) {
        validationResource(dealResource);
        DealEntity dealEntity = new DealEntity();
        dealEntity.setOrderingCurrency(dealResource.getOrderingCurrency());
        dealEntity.setAmount(dealResource.getAmount());
        dealEntity.setDateTime(LocalDateTime.now());
        dealEntity.setCodeCurrency(dealResource.getCodeCurrency());
        return dealEntity;
    }

    private void validationResource(DealResource dealResource) {
        Map <String,String> errors=new HashMap<>();
        if (Objects.isNull(dealResource.getOrderingCurrency())
                || dealResource.getOrderingCurrency().length() < 3) {
            errors.put("orderingCurrency","Ordering Currency is invalid");
        }

        if (dealResource.getAmount() < 0
                || Objects.isNull(dealResource.getAmount())) {
            errors.put("amount","Amount is negative");

        }

        if (dealResource.getCodeCurrency().isEmpty()
                || dealResource.getCodeCurrency().length() < 3) {

            errors.put("codeCurrency","Code Currency is invalid");

        }

        if(!errors.isEmpty()){
           throw new FxDealValidationException("missing filed",errors) ;
        }
    }

    public DealResource toDealResource(DealEntity dealEntity) {
        DealResource dealResource = new DealResource();
        dealResource.setOrderingCurrency(dealEntity.getOrderingCurrency());
        dealResource.setAmount(dealEntity.getAmount());
        dealResource.setDateTime(dealEntity.getDateTime());
        dealResource.setCodeCurrency(dealEntity.getCodeCurrency());
        return dealResource;
    }
}
