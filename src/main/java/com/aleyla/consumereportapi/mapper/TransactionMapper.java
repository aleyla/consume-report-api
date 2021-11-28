package com.aleyla.consumereportapi.mapper;

import com.aleyla.consumereportapi.dto.Transaction;
import com.aleyla.consumereportapi.entity.TransactionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    Transaction map(TransactionEntity entity);

}
