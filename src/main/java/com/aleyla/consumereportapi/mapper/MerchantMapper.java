package com.aleyla.consumereportapi.mapper;

import com.aleyla.consumereportapi.dto.Merchant;
import com.aleyla.consumereportapi.entity.MerchantEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MerchantMapper {

    Merchant map(MerchantEntity entity);

}
