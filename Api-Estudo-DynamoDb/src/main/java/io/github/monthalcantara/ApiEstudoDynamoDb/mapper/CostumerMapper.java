package io.github.monthalcantara.ApiEstudoDynamoDb.mapper;

import io.github.monthalcantara.ApiEstudoDynamoDb.dto.response.CostumerResponse;
import io.github.monthalcantara.ApiEstudoDynamoDb.dto.request.CostumerRequest;
import io.github.monthalcantara.ApiEstudoDynamoDb.model.Costumer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CostumerMapper {

    @Mapping(target = "active", defaultValue = "true")
    Costumer toCostumer(CostumerRequest costumerRequest);

    CostumerResponse toCostumerResponse(Costumer costumer);

   List<CostumerResponse> toListCostumerResponse(List<Costumer> costumer);
}
