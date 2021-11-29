package com.aleyla.consumereportapi.model.mapper;

import com.aleyla.consumereportapi.model.dto.Merchant;
import com.aleyla.consumereportapi.model.entity.MerchantEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MerchantMapper {

    Merchant map(MerchantEntity entity);

}
