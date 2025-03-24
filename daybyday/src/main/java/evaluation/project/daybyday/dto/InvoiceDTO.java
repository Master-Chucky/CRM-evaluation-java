package evaluation.project.daybyday.dto;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class InvoiceDTO {
    
    private int id;
    
    @JsonProperty("external_id")
    private String externalId;
    
    private String status;
    
    @JsonProperty("invoice_number")
    private String invoiceNumber;
    
    @JsonProperty("sent_at")
    private ZonedDateTime sentAt;
    
    @JsonProperty("due_at")
    private ZonedDateTime dueAt;
    
    @JsonProperty("integration_invoice_id")
    private String integrationInvoiceId;
    
    @JsonProperty("integration_type")
    private String integrationType;
    
    @JsonProperty("source_type")
    private String sourceType;
    
    @JsonProperty("source_id")
    private Integer sourceId;
    
    @JsonProperty("client_id")
    private int clientId;
    
    @JsonProperty("offer_id")
    private Integer offerId;
    
    @JsonProperty("deleted_at")
    private ZonedDateTime deletedAt;
    
    @JsonProperty("created_at")
    private ZonedDateTime createdAt;
    
    @JsonProperty("updated_at")
    private ZonedDateTime updatedAt;

}
