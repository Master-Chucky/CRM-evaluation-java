package evaluation.project.daybyday.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ClientDTO {
    
    private int id;

    @JsonProperty("external_id")
    private String externalId;

    private String address;

    private String zipcode;

    private String city;

    @JsonProperty("company_name")
    private String companyName;

    private String vat;

    @JsonProperty("company_type")
    private String companyType;

    @JsonProperty("client_number")
    private String clientNumber;

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("industry_id")
    private int industryId;

    @JsonProperty("deleted_at")
    private String deletedAt;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

}
