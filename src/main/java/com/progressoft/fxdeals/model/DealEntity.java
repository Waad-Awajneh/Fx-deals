package com.progressoft.fxdeals.model;


import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
public class DealEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String orderingCurrency;
    private String codeCurrency;
    private LocalDateTime dateTime;
    private Double amount;

    public DealEntity(String orderingCurrency,
                      String codeCurrency,
                      LocalDateTime dateTime,
                      Double amount) {
        this.orderingCurrency = orderingCurrency;
        this.codeCurrency = codeCurrency;
        this.dateTime = dateTime;
        this.amount = amount;
    }

    public DealEntity() {

    }

    public String getOrderingCurrency() {
        return orderingCurrency;
    }

    public void setOrderingCurrency(String orderingCurrency) {
        this.orderingCurrency = orderingCurrency;
    }

    public String getCodeCurrency() {
        return codeCurrency;
    }

    public void setCodeCurrency(String codeCurrency) {
        this.codeCurrency = codeCurrency;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
