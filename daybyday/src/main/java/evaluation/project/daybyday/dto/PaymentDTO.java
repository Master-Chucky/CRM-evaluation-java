package evaluation.project.daybyday.dto;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PaymentDTO {
    
    private int id;
    
    @JsonProperty("external_id")
    private String externalId;
    
    private int amount;
    
    private String description;
    
    @JsonProperty("payment_source")
    private String paymentSource;
    
    @JsonProperty("payment_date")
    private ZonedDateTime paymentDate;
    
    @JsonProperty("integration_payment_id")
    private String integrationPaymentId;
    
    @JsonProperty("integration_type")
    private String integrationType;
    
    @JsonProperty("invoice_id")
    private int invoiceId;
    
    @JsonProperty("deleted_at")
    private ZonedDateTime deletedAt;
    
    @JsonProperty("created_at")
    private ZonedDateTime createdAt;
    
    @JsonProperty("updated_at")
    private ZonedDateTime updatedAt;

}
