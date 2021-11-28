package com.aleyla.consumereportapi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billing_address_id")
    private AddressEntity billingAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_address_id")
    private AddressEntity shippingAddress;

}
