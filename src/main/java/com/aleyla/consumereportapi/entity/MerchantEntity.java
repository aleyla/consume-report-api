package com.aleyla.consumereportapi.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "merchant")
@EqualsAndHashCode(callSuper = true)
public class MerchantEntity extends BaseEntity {

    private String name;

}
