package com.aleyla.consumereportapi.mapper;

import com.aleyla.consumereportapi.dto.Acquirer;
import com.aleyla.consumereportapi.entity.AcquirerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcquirerMapper {

    Acquirer map(AcquirerEntity entity);
}
