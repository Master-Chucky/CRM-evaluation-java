package evaluation.project.daybyday.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProjectChartDTO {
    
    @JsonProperty("Open")
    private int open;

    @JsonProperty("In-progress")
    private int inProgress;

    @JsonProperty("Blocked")
    private int blocked;

    @JsonProperty("Cancelled")
    private int cancelled;

    @JsonProperty("Completed")
    private int completed;

}
