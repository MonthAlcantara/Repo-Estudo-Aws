package io.github.monthalcantara.ApiEstudoDynamoDb.service;

import io.github.monthalcantara.ApiEstudoDynamoDb.dto.request.CostumerRequest;
import io.github.monthalcantara.ApiEstudoDynamoDb.model.Costumer;
import io.github.monthalcantara.ApiEstudoDynamoDb.repository.CostumerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CostumerServiceImpl implements CostumerService{

    private final CostumerRepository costumerRepository;

    public CostumerServiceImpl(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    @Override
    public Costumer saveCostumer(Costumer costumer) {
        if(costumerRepository.findByCompanyDocumentNumber(costumer.getCompanyDocumentNumber()).isPresent()) {
            throw new RuntimeException("There is already a customer with this document number");
        }
        return costumerRepository.save(costumer);
    }

    @Override
    public Costumer findById(String id) {
        return costumerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Costumer not found"));
    }

    @Override
    public List<Costumer> findAllCostumers() {
        return (List<Costumer>) costumerRepository.findAll();
    }

    @Override
    public List<Costumer> findByCompanyName(String companyName) {
        return costumerRepository.findByCompanyName(companyName);
    }

    @Override
    public Costumer updateCostumer(String companyDocumentNumber, CostumerRequest costumerRequest) {
        Optional<Costumer> costumer =
                costumerRepository.findByCompanyDocumentNumber(companyDocumentNumber);

        if(costumer.isEmpty()) {
            throw new RuntimeException("There is no customer with this document number");
        }

        BeanUtils.copyProperties(costumerRequest, costumer.get(), "active", "id");

        return costumerRepository.save(costumer.get());
    }

    @Override
    public Costumer disableCostumer(String companyDocumentNumber) {
        Optional<Costumer> costumer =
                costumerRepository.findByCompanyDocumentNumber(companyDocumentNumber);

        if(costumer.isEmpty()) {
            throw new RuntimeException("There is no customer with this document number");
        }

        costumer.get().setActive(false);

        return costumerRepository.save(costumer.get());
    }
}
