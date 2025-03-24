package evaluation.project.daybyday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import evaluation.project.daybyday.service.PaymentService;
import evaluation.project.daybyday.util.PaymentResponseDTO;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public String getTasks(@RequestParam(defaultValue = "1") int page, Model model) {
        PaymentResponseDTO response = paymentService.getTasks(page);

        model.addAttribute("data", response.getData());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", response.getLastPage());
        model.addAttribute("totalTasks", response.getTotal());
        model.addAttribute("nextPage", page < response.getLastPage() ? page + 1 : null);
        model.addAttribute("prevPage", page > 1 ? page - 1 : null);

        return "payment/liste";
    }
}

