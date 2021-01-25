package io.github.monthalcantara.ApiEstudoDynamoDb.service;

import io.github.monthalcantara.ApiEstudoDynamoDb.dto.request.CostumerRequest;
import io.github.monthalcantara.ApiEstudoDynamoDb.model.Costumer;

import java.util.List;

public interface CostumerService {

    Costumer saveCostumer(Costumer costumer);

    Costumer findById(String id);

    List<Costumer> findAllCostumers();

    List<Costumer> findByCompanyName(String companyName);

    Costumer updateCostumer(String companyDocumentNumber, CostumerRequest costumerRequest);

    Costumer disableCostumer(String companyDocumentNumber);
}
