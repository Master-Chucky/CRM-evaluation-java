package evaluation.project.daybyday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import evaluation.project.daybyday.service.ProjectService;
import evaluation.project.daybyday.util.ProjectResponseDTO;

@Controller
@RequestMapping("/project")
public class ProjectController {
    
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String getProjects(@RequestParam(defaultValue = "1") int page, Model model) {
        ProjectResponseDTO response = projectService.getProjects(page);

        model.addAttribute("data", response.getData());  
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", response.getLastPage());
        model.addAttribute("totalTasks", response.getTotal());
        model.addAttribute("nextPage", page < response.getLastPage() ? page + 1 : null);
        model.addAttribute("prevPage", page > 1 ? page - 1 : null);

        return "task/liste";
    }

}
