package evaluation.project.daybyday.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import evaluation.project.daybyday.dto.InvoiceChartDTO;
import evaluation.project.daybyday.dto.ProjectChartDTO;

@Service
public class ChartService {
    
    @Value("${api.base.url}")
    private String apiBaseUrl;

    private final RestTemplate restTemplate;

    public ChartService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProjectChartDTO getProjectChartData() {
        @SuppressWarnings("deprecation")
        String url = UriComponentsBuilder.fromHttpUrl(apiBaseUrl)
                                       .path("/project/chart")
                                       .toUriString();
        ResponseEntity<ProjectChartDTO> response = restTemplate.getForEntity(url, ProjectChartDTO.class);
        return response.getBody();
    }

    public InvoiceChartDTO getInvoiceChartData() {
        @SuppressWarnings("deprecation")
        String url = UriComponentsBuilder.fromHttpUrl(apiBaseUrl)
                                       .path("/invoice/chart")
                                       .toUriString();
        ResponseEntity<InvoiceChartDTO> response = restTemplate.getForEntity(url, InvoiceChartDTO.class);
        return response.getBody();
    }

}
