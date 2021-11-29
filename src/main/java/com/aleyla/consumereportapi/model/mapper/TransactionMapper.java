package com.aleyla.consumereportapi.model.mapper;

import com.aleyla.consumereportapi.model.dto.Transaction;
import com.aleyla.consumereportapi.model.entity.TransactionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    Transaction map(TransactionEntity entity);

}
