package com.aleyla.consumereportapi.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "address")
@EqualsAndHashCode(callSuper = true)
public class AddressEntity extends BaseEntity {

    private String title;

    private String firstName;

    private String lastName;

    private String company;

    private String address1;

    private String address2;

    private String city;

    private String postcode;

    private String state;

    private String country;

    private String phone;

    private String fax;
}
