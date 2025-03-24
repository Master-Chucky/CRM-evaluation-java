package evaluation.project.daybyday.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import evaluation.project.daybyday.util.InvoiceResponseDTO;

@Service
public class InvoiceService {
    
    @Value("${api.base.url}")
    private String apiBaseUrl;

    private final RestTemplate restTemplate;

    public InvoiceService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public InvoiceResponseDTO getTasks(int page) {
        @SuppressWarnings("deprecation")
        String url = UriComponentsBuilder.fromHttpUrl(apiBaseUrl)
                                       .path("/invoice")
                                       .queryParam("page", page)
                                       .toUriString();

        ResponseEntity<InvoiceResponseDTO> response = restTemplate.getForEntity(url, InvoiceResponseDTO.class);
        return response.getBody();
    }

}
