package com.aleyla.consumereportapi.repository;

import com.aleyla.consumereportapi.model.entity.AcquirerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcquirerRepository extends JpaRepository<AcquirerEntity, Long> {

}
