package com.aleyla.consumereportapi.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "customer_info")
@EqualsAndHashCode(callSuper = true)
public class CustomerInfoEntity extends BaseEntity {

    private String number;

    private String expiryMonth;

    private String expiryYear;

    private String startMonth;

    private String startYear;

    private String issueNumber;

    private String email;

    @OneToOne
    @JoinColumn(name = "billing_address_id")
    private AddressEntity billingAddress;

    @OneToOne
    @JoinColumn(name = "shipping_address_id")
    private AddressEntity shippingAddress;

}
