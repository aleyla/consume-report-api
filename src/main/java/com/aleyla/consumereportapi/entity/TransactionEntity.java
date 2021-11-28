package com.aleyla.consumereportapi.entity;

import com.aleyla.consumereportapi.enums.Currency;
import com.aleyla.consumereportapi.enums.Operation;
import com.aleyla.consumereportapi.enums.PaymentMethod;
import com.aleyla.consumereportapi.enums.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "trancaction")
@EqualsAndHashCode(callSuper = true)
public class TransactionEntity extends BaseEntity {

    private BigDecimal amount;
    @Column(length = 3)
    @Enumerated(EnumType.STRING)
    private Currency currency;

    private LocalDate txDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerInfoEntity customerInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    private MerchantEntity merchant;

    @ManyToOne(fetch = FetchType.LAZY)
    private AcquirerEntity acquirer;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Operation operation;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private String referenceNo;

    private String errorCode;

}