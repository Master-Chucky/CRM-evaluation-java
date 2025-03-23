package evaluation.project.daybyday.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import evaluation.project.daybyday.dto.TaskResponseDTO;

@Service
public class TaskService {
    
    @Value("${api.base.url}")
    private String apiBaseUrl;

    private final RestTemplate restTemplate;

    public TaskService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public TaskResponseDTO getTasks(int page) {
        @SuppressWarnings("deprecation")
        String url = UriComponentsBuilder.fromHttpUrl(apiBaseUrl)
                                       .path("/task")
                                       .queryParam("page", page)
                                       .toUriString();

        ResponseEntity<TaskResponseDTO> response = restTemplate.getForEntity(url, TaskResponseDTO.class);

        return response.getBody();
    }
}
