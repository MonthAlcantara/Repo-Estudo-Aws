package io.github.monthalcantara.ApiEstudoDynamoDb.controller;

import io.github.monthalcantara.ApiEstudoDynamoDb.dto.response.CostumerResponse;
import io.github.monthalcantara.ApiEstudoDynamoDb.dto.request.CostumerRequest;
import io.github.monthalcantara.ApiEstudoDynamoDb.mapper.CostumerMapper;
import io.github.monthalcantara.ApiEstudoDynamoDb.model.Costumer;
import io.github.monthalcantara.ApiEstudoDynamoDb.repository.CostumerRepository;
import io.github.monthalcantara.ApiEstudoDynamoDb.service.CostumerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1")
public class CostumerController {

    private final CostumerService costumerService;
    private final CostumerRepository costumerRepository;
    private final CostumerMapper MAPPER;

    @PostMapping("costumer")
    public ResponseEntity<Costumer> newCostumer(@Valid @RequestBody CostumerRequest costumerRequest) {

        log.info("Recebido costumer {}", costumerRequest);

        Costumer costumer = MAPPER.toCostumer(costumerRequest);

        log.info("Conversao request para model feita com sucesso");

        Costumer costumerSalvo = costumerService.saveCostumer(costumer);

        log.info("Costumer salvo com sucesso: {}", costumerSalvo.getId());

        CostumerResponse costumerResponse = MAPPER.toCostumerResponse(costumerSalvo);

        log.info("Conversao model para request feita com sucesso");

        return new ResponseEntity(costumerResponse, HttpStatus.OK);
    }

    @GetMapping("costumer")
    public ResponseEntity<List<CostumerResponse>> findCostumerByName(@Param("companyName") String companyName) {
        List<Costumer> costumers = costumerService.findByCompanyName(companyName);

        List<CostumerResponse> costumersResponse = costumers.stream().map(CostumerResponse::new).collect(Collectors.toList());

        return ResponseEntity.ok(costumersResponse);
    }

    @GetMapping("costumer/all")
    public ResponseEntity<List<CostumerResponse>> allCostumers() {
        List<CostumerResponse> allCostumers = costumerService.findAllCostumers()
                .stream().map(CostumerResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(allCostumers);
    }

    @GetMapping("costumer/{id}")
    public ResponseEntity<CostumerResponse> findById(@PathVariable("id") String id) {
        Costumer costumer = costumerService.findById(id);

        return ResponseEntity.ok(new CostumerResponse(costumer));
    }

    @PutMapping("costumer")
    public ResponseEntity<CostumerResponse> updateCostumer(@Valid @RequestBody CostumerRequest costumerRequest) {
        Costumer costumer = costumerService.updateCostumer(costumerRequest.getCompanyDocumentNumber(), costumerRequest);
        CostumerResponse costumerResponse = new CostumerResponse(costumer);
        return ResponseEntity.ok(costumerResponse);
    }

    @DeleteMapping("costumer/{companyName}")
    public ResponseEntity<CostumerResponse> disableCostumer(@PathVariable("companyName") String companyName) {
        Costumer costumer = costumerService.disableCostumer(companyName);
        CostumerResponse costumerResponse = new CostumerResponse(costumer);
        return ResponseEntity.ok(costumerResponse);
    }
}
