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

    public static Specification<TransactionEntity> customer(Long id) {
        return (Specification<TransactionEntity>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("customerInfo"), id);
    }

    public static Specification<TransactionEntity> status(Status status) {
        return (Specification<TransactionEntity>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
    }

    public static Specification<TransactionEntity> operation(Operation operation) {
        return (Specification<TransactionEntity>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("operation"), operation);
    }

    public static Specification<TransactionEntity> errorCode(String errorCode) {
        return (Specification<TransactionEntity>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("errorCode"), errorCode);
    }

    public static Specification<TransactionEntity> filter(String field, String value) {
        return (Specification<TransactionEntity>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(field), value);
    }

    public static Specification<TransactionEntity> fromTo(LocalDate from, LocalDate to) {
        return (Specification<TransactionEntity>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.between(root.get("txDate"), from, to);
    }

    public static Specification<TransactionEntity> paymentMethod(PaymentMethod paymentMethod) {
        return (Specification<TransactionEntity>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("paymentMethod"),
                                                                                                                  paymentMethod);
    }


}
