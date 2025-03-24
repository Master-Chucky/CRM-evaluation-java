package evaluation.project.daybyday.controller;

import evaluation.project.daybyday.service.TaskService;
import evaluation.project.daybyday.util.TaskResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(@RequestParam(defaultValue = "1") int page, Model model) {
        TaskResponseDTO response = taskService.getTasks(page);

        model.addAttribute("data", response.getData());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", response.getLastPage());
        model.addAttribute("totalTasks", response.getTotal());
        model.addAttribute("nextPage", page < response.getLastPage() ? page + 1 : null);
        model.addAttribute("prevPage", page > 1 ? page - 1 : null);

        return "task/liste";
    }
}
