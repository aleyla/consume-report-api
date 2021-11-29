package com.aleyla.consumereportapi.repository.transaction;

import com.aleyla.consumereportapi.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long>, JpaSpecificationExecutor<TransactionEntity> {

    @Query("SELECT e FROM TransactionEntity e INNER JOIN FETCH e.customerInfo WHERE e.id = :id")
    Optional<TransactionEntity> findByIdFetchCustomer(@Param("id") Long id);

    @Query("SELECT e FROM TransactionEntity e INNER JOIN FETCH e.customerInfo " +
            "INNER JOIN FETCH e.merchant  " +
            "INNER JOIN FETCH e.acquirer WHERE e.id = :id")
    Optional<TransactionEntity> findByIdFetchDetail(@Param("id") Long id);

    @Query("SELECT e FROM TransactionEntity e INNER JOIN FETCH e.customerInfo " +
            "INNER JOIN FETCH e.merchant  " +
            "INNER JOIN FETCH e.acquirer")
    List<TransactionEntity> findAll();
}
