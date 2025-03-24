package evaluation.project.daybyday.dto;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OfferDTO {
    
    private int id;
    
    @JsonProperty("external_id")
    private String externalId;
    
    @JsonProperty("sent_at")
    private ZonedDateTime sentAt;
    
    @JsonProperty("source_type")
    private String sourceType;
    
    @JsonProperty("source_id")
    private int sourceId;
    
    @JsonProperty("client_id")
    private int clientId;
    
    private String status;
    
    @JsonProperty("deleted_at")
    private ZonedDateTime deletedAt;
    
    @JsonProperty("created_at")
    private ZonedDateTime createdAt;
    
    @JsonProperty("updated_at")
    private ZonedDateTime updatedAt;

}
