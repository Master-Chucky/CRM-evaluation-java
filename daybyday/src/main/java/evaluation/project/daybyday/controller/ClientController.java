package evaluation.project.daybyday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import evaluation.project.daybyday.util.ClientResponseDTO;

import evaluation.project.daybyday.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {
    
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

        @GetMapping
    public String getClients(@RequestParam(defaultValue = "1") int page, Model model) {
        ClientResponseDTO clientResponse = clientService.getClients(page);

        model.addAttribute("data", clientResponse.getData());  
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", clientResponse.getLastPage());
        model.addAttribute("totalTasks", clientResponse.getTotal());
        model.addAttribute("nextPage", page < clientResponse.getLastPage() ? page + 1 : null);
        model.addAttribute("prevPage", page > 1 ? page - 1 : null);

        return "client/liste";
    }

}
