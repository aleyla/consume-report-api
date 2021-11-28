package com.aleyla.consumereportapi.repository.transaction;

import com.aleyla.consumereportapi.entity.TransactionEntity;
import com.aleyla.consumereportapi.enums.Operation;
import com.aleyla.consumereportapi.enums.PaymentMethod;
import com.aleyla.consumereportapi.enums.Status;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class TransactionSpecification {


    public static Specification<TransactionEntity> merchant(Long id) {
        return (Specification<TransactionEntity>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("merchant"), id);
    }

    public static Specification<TransactionEntity> acquirer(Long id) {
        return (Specification<TransactionEntity>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("acquirer"), id);
    }
    public static Specification<TransactionEntity> fromTo(LocalDate from, LocalDate to) {
        return (Specification<TransactionEntity>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.between(root.get("transactionDate"), from, to);
    }


}
