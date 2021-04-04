package io.github.monthalcantara.ApiEstudoDynamoDb.repository;

import io.github.monthalcantara.ApiEstudoDynamoDb.model.Costumer;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * @EnableScan: Essa annotation diz para o Spring Data que a interface será responsável pelas funcionalidades de CRUD,
 * ou seja, ler e persistir dados na tabela do DynamoDB.
 */
@EnableScan
public interface CostumerRepository extends CrudRepository<Costumer, String> {

    List<Costumer> findByCompanyName(String companyName);

    Optional<Costumer> findByCompanyDocumentNumber(String companyDocumentNumber);

    Optional<Costumer> findById(String id);
}
