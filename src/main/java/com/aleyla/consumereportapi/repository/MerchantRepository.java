package com.aleyla.consumereportapi.repository;

import com.aleyla.consumereportapi.model.entity.MerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<MerchantEntity, Long> {

}
