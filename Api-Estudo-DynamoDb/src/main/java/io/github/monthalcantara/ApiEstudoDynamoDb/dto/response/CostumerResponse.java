package io.github.monthalcantara.ApiEstudoDynamoDb.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.monthalcantara.ApiEstudoDynamoDb.model.Costumer;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CostumerResponse {

    @NotBlank
    private String companyName;

    @NotBlank
    private String companyDocumentNumber;

    @NotBlank
    private String phoneNumber;

    private Boolean active;

    @Deprecated
    public CostumerResponse() {
    }

    public CostumerResponse(@NotNull @NotBlank String companyName,
                            @NotNull @NotBlank String companyDocumentNumber,
                            @NotNull @NotBlank String phoneNumber,
                            Boolean active) {
        this.companyName = companyName;
        this.companyDocumentNumber = companyDocumentNumber;
        this.phoneNumber = phoneNumber;
        this.active = active;
    }

    public CostumerResponse(Costumer costumer) {

                this.companyName = costumer.getCompanyName();
                this.companyDocumentNumber = costumer.getCompanyDocumentNumber();
                this.phoneNumber = costumer.getPhoneNumber();
                this.active = costumer.getActive();

    }
}
