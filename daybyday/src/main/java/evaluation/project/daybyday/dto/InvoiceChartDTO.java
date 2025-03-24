package evaluation.project.daybyday.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class InvoiceChartDTO {
    
    @JsonProperty("total_paid")
    private double totalPaid;

    @JsonProperty("total_unpaid")
    private double totalUnpaid;

}
