package com.aleyla.consumereportapi.model.mapper;

import com.aleyla.consumereportapi.model.dto.CustomerInfo;
import com.aleyla.consumereportapi.model.entity.CustomerInfoEntity;
import com.aleyla.consumereportapi.model.response.ClientInfoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Mapper(componentModel = "spring")
public interface CustomerInfoMapper {


    @Mappings({ @Mapping(source = "billingAddress.city", target = "billingCity"),
                @Mapping(source = "billingAddress.title", target = "billingTitle")})
    CustomerInfo mapper(CustomerInfoEntity entity);

    default ClientInfoResponse map(CustomerInfoEntity entity) {
        ClientInfoResponse response = new ClientInfoResponse();
        CustomerInfo mapper = mapper(entity);
        mapper.setCreatedAt(LocalDateTime.ofInstant(entity.getCreatedDate(), ZoneId.systemDefault()));
        mapper.setUpdatedAt(LocalDateTime.ofInstant(entity.getUpdatedDate(), ZoneId.systemDefault()));
        response.setCustomerInfo(mapper);
        return response;
    }
}
