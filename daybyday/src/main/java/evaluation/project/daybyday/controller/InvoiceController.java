package evaluation.project.daybyday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import evaluation.project.daybyday.service.InvoiceService;
import evaluation.project.daybyday.util.InvoiceResponseDTO;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    
    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public String getTasks(@RequestParam(defaultValue = "1") int page, Model model) {
        InvoiceResponseDTO response = invoiceService.getTasks(page);

        model.addAttribute("data", response.getData());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", response.getLastPage());
        model.addAttribute("totalTasks", response.getTotal());
        model.addAttribute("nextPage", page < response.getLastPage() ? page + 1 : null);
        model.addAttribute("prevPage", page > 1 ? page - 1 : null);

        return "invoice/liste";
    }

}
