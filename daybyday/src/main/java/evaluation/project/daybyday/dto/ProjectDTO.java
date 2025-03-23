package evaluation.project.daybyday.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProjectDTO {
    
    private int id;

    @JsonProperty("external_id")
    private String externalId;

    private String title;
    private String description;

    @JsonProperty("status_id")
    private int statusId;

    @JsonProperty("user_assigned_id")
    private int userAssignedId;

    @JsonProperty("user_created_id")
    private int userCreatedId;

    @JsonProperty("client_id")
    private int clientId;

    @JsonProperty("invoice_id")
    private int invoiceId;

    private String deadline;

    @JsonProperty("deleted_at")
    private String deletedAt;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

}
