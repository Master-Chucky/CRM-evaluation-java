package evaluation.project.daybyday.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import evaluation.project.daybyday.util.ClientResponseDTO;

@Service
public class ClientService {
    
    @Value("${api.base.url}")
    private String apiBaseUrl;

    private final RestTemplate restTemplate;

    public ClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ClientResponseDTO getClients(int page) {
        @SuppressWarnings("deprecation")
        String url = UriComponentsBuilder.fromHttpUrl(apiBaseUrl)
                                       .path("/client")
                                       .queryParam("page", page)
                                       .toUriString();
        ResponseEntity<ClientResponseDTO> response = restTemplate.getForEntity(url, ClientResponseDTO.class);
        return response.getBody();
    }

}
