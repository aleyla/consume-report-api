package com.aleyla.consumereportapi.mapper;

import com.aleyla.consumereportapi.dto.MerchantTransaction;
import com.aleyla.consumereportapi.entity.TransactionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    MerchantTransaction map(TransactionEntity entity);

}
