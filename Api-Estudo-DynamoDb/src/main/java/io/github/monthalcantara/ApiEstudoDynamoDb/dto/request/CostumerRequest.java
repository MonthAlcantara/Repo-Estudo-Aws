package io.github.monthalcantara.ApiEstudoDynamoDb.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.monthalcantara.ApiEstudoDynamoDb.model.Costumer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
public class CostumerRequest {

    @NotBlank
    @JsonProperty("company_name")
    private String companyName;

    @NotBlank
    @JsonProperty("company_document_number")
    private String companyDocumentNumber;

    @NotBlank
    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("active")
    private Boolean active;

    @Deprecated
    public CostumerRequest() {
    }

    public CostumerRequest(@NotNull @NotBlank String companyName,
                           @NotNull @NotBlank String companyDocumentNumber,
                           @NotNull @NotBlank String phoneNumber,
                           Boolean active) {
        this.companyName = companyName;
        this.companyDocumentNumber = companyDocumentNumber;
        this.phoneNumber = phoneNumber;
        this.active = active;
    }

    public Costumer costumerDTOToCostumer() {
        return new Costumer(
                this.companyName,
                this.companyDocumentNumber,
                this.phoneNumber,
                true
        );
    }
}
