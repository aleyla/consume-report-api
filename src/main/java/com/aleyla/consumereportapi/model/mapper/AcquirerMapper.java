package com.aleyla.consumereportapi.model.mapper;

import com.aleyla.consumereportapi.model.dto.Acquirer;
import com.aleyla.consumereportapi.model.entity.AcquirerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcquirerMapper {

    Acquirer map(AcquirerEntity entity);
}
