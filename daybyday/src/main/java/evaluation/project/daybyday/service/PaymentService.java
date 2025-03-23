package evaluation.project.daybyday.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import evaluation.project.daybyday.util.PaymentResponseDTO;

@Service
public class PaymentService {
    
    @Value("${api.base.url}")
    private String apiBaseUrl;

    private final RestTemplate restTemplate;

    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PaymentResponseDTO getTasks(int page) {
        @SuppressWarnings("deprecation")
        String url = UriComponentsBuilder.fromHttpUrl(apiBaseUrl)
                                       .path("/payment")
                                       .queryParam("page", page)
                                       .toUriString();

        ResponseEntity<PaymentResponseDTO> response = restTemplate.getForEntity(url, PaymentResponseDTO.class);
        return response.getBody();
    }

}
