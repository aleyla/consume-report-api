package com.aleyla.consumereportapi.entity;

import com.aleyla.consumereportapi.enums.PaymentMethod;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "acquirer")
@EqualsAndHashCode(callSuper = true)
public class AcquirerEntity extends BaseEntity {

    private String name;

    private String code;

    @Enumerated(EnumType.STRING)
    private PaymentMethod type;

}
