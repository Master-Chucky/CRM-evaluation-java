package evaluation.project.daybyday.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import evaluation.project.daybyday.util.ProjectResponseDTO;

@Service
public class ProjectService {
    
    @Value("${api.base.url}")
    private String apiBaseUrl;

    private final RestTemplate restTemplate;

    public ProjectService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProjectResponseDTO getProjects(int page) {
        @SuppressWarnings("deprecation")
        String url = UriComponentsBuilder.fromHttpUrl(apiBaseUrl)
                                       .path("/project")
                                       .queryParam("page", page)
                                       .toUriString();

        ResponseEntity<ProjectResponseDTO> response = restTemplate.getForEntity(url, ProjectResponseDTO.class);
        return response.getBody();
    }

}
