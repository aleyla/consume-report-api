package com.aleyla.consumereportapi.mapper;

import com.aleyla.consumereportapi.dto.CustomerInfo;
import com.aleyla.consumereportapi.entity.CustomerInfoEntity;
import com.aleyla.consumereportapi.response.ClientInfoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerInfoMapper {

    CustomerInfo mapper(CustomerInfoEntity entity);

    default ClientInfoResponse map(CustomerInfoEntity entity) {
        ClientInfoResponse response = new ClientInfoResponse();
        response.setCustomerInfo(mapper(entity));
        return response;
    }
}
