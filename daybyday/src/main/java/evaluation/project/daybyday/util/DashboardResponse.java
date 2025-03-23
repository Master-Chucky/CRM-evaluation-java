package evaluation.project.daybyday.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    private int nbClients;
    private int nbProjects;
    private int nbTasks;
    private int nbOffers;
    private int nbInvoices;
    private int nbPayments;
    private int nbInvoiceLines;

}
