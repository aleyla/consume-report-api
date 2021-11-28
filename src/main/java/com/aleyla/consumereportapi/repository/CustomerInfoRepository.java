package com.aleyla.consumereportapi.repository;

import com.aleyla.consumereportapi.entity.CustomerInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfoEntity, Long> {
}
