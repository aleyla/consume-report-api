package com.aleyla.consumereportapi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "agent")
@EqualsAndHashCode(callSuper = true)
public class AgentEntity extends BaseEntity {

    private String customerIp;

    private String customerUserAgent;

    private String merchantIp;
}
