package evaluation.project.daybyday.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import evaluation.project.daybyday.util.OfferResponseDTO;

@Service
public class OfferService {
    
    @Value("${api.base.url}")
    private String apiBaseUrl;

    private final RestTemplate restTemplate;

    public OfferService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public OfferResponseDTO getOffers(int page) {
        @SuppressWarnings("deprecation")
        String url = UriComponentsBuilder.fromHttpUrl(apiBaseUrl)
                                       .path("/offer")
                                       .queryParam("page", page)
                                       .toUriString();

        ResponseEntity<OfferResponseDTO> response = restTemplate.getForEntity(url, OfferResponseDTO.class);
        return response.getBody();
    }

}
