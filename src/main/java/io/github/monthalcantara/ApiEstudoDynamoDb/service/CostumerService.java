package io.github.monthalcantara.ApiEstudoDynamoDb.service;

import io.github.monthalcantara.ApiEstudoDynamoDb.dto.CostumerDTO;
import io.github.monthalcantara.ApiEstudoDynamoDb.model.Costumer;

import java.util.List;

public interface CostumerService {
    Costumer saveCostumer(CostumerDTO costumerDTO);
    List<Costumer> findAllCostumers();
    List<Costumer> findByCompanyName(String companyName);
    Costumer updateCostumer(String companyDocumentNumber, CostumerDTO costumerDTO);
    Costumer disableCostumer(String companyDocumentNumber);
}
