package evaluation.project.daybyday.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import evaluation.project.daybyday.util.DashboardResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import java.util.Map;

@Service
public class DashboardService {
    
    @Value("${api.base.url}")
    private String apiBaseUrl;   

    public DashboardResponse getDashboardData() throws Exception {
        // Appel à l'API pour récupérer les projets par statut
        Map<String, Integer> projectStatusCount = getProjectCountByStatus();

        // Extraction du nombre de projets pour chaque statut
        // Exemple pour obtenir le nombre de projets "Open"
        int nbProjects = projectStatusCount.getOrDefault("Open", 0);  
        
        // Appels aux autres entités comme avant
        int nbClients = getEntityCount("client/nb");
        int nbTasks = getEntityCount("task/nb");
        int nbOffers = getEntityCount("offer/nb");
        int nbInvoices = getEntityCount("invoice/nb");
        int nbPayments = getEntityCount("payment/nb");
        int nbInvoiceLines = getEntityCount("invoice-line/nb");

        DashboardResponse dashboardResponse = new DashboardResponse(nbClients, nbProjects, nbTasks, nbOffers, nbInvoices, nbPayments, nbInvoiceLines);

        return dashboardResponse;
    }

    @SuppressWarnings("deprecation")
    private int getEntityCount(String endpoint) throws Exception {
        String url = apiBaseUrl + "/" + endpoint;

        RestTemplate restTemplate = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            
            if (response.getStatusCodeValue() != 200) {
                throw new Exception("Erreur lors de la récupération des données.");
            }
            
            ObjectMapper objectMapper = new ObjectMapper();
            @SuppressWarnings("unchecked")
            Map<String, Integer> responseMap = objectMapper.readValue(response.getBody(), Map.class);
            
            return responseMap.values().stream().findFirst().orElse(0);
        } catch (HttpClientErrorException e) {
            throw new Exception("Erreur lors de l'appel API pour " + endpoint);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public Map<String, Integer> getProjectCountByStatus() throws Exception {
        String url = apiBaseUrl + "/project/chart";
        RestTemplate restTemplate = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            
            if (response.getStatusCodeValue() != 200) {
                throw new Exception("Erreur lors de la récupération des données.");
            }
            
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Integer> projectStatusMap = objectMapper.readValue(response.getBody(), Map.class);
            
            return projectStatusMap; 
        } catch (HttpClientErrorException e) {
            throw new Exception("Erreur lors de l'appel API pour le nombre de projets par statut.");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public Map<String, Integer> getMonthlyRevenueChart() throws Exception {
         
        String url = apiBaseUrl + "/payment/chart"; 
        
        RestTemplate restTemplate = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            
            if (response.getStatusCodeValue() != 200) {
                throw new Exception("Erreur lors de la récupération des données.");
            }
            
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Integer> revenueData = objectMapper.readValue(response.getBody(), Map.class);
            
            return revenueData; 
        } catch (HttpClientErrorException e) {
            throw new Exception("Erreur lors de l'appel API pour les revenus mensuels.");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
