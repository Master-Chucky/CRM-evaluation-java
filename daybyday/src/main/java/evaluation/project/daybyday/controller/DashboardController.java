package evaluation.project.daybyday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import evaluation.project.daybyday.service.ChartService;
import evaluation.project.daybyday.service.DashboardService;
import evaluation.project.daybyday.util.DashboardResponse;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    
    @Autowired
    private DashboardService dashboardService;

    @Autowired
    private ChartService chartService;

    @GetMapping
    public String getDashboardData(Model model) {

        try {
            DashboardResponse dashboardResponse = dashboardService.getDashboardData();
            model.addAttribute("nbClients", dashboardResponse.getNbClients());
            model.addAttribute("nbProjects", dashboardResponse.getNbProjects());
            model.addAttribute("nbTasks", dashboardResponse.getNbTasks());
            model.addAttribute("nbOffers", dashboardResponse.getNbOffers());
            model.addAttribute("nbInvoices", dashboardResponse.getNbInvoices());
            model.addAttribute("nbPayments", dashboardResponse.getNbPayments());
            model.addAttribute("nbInvoiceLines", dashboardResponse.getNbInvoiceLines());
            model.addAttribute("projectChartData", chartService.getProjectChartData());
            System.out.println(model.getAttribute("projectChartData"));
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("erreur", "Erreur lors de la récupération des données du tableau de bord.");
        }
        return "page/dashboard";
    }

}
