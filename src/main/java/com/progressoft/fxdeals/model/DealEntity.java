package com.progressoft.fxdeals.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
public class RequestEntity {

    @Id
    private Integer id;
    private String orderingCurrency;
    private String codeCurrency;
    private LocalDateTime dateTime;
    private String amount;

}
