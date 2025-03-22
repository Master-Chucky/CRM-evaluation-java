package evaluation.project.daybyday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import evaluation.project.daybyday.dto.LoginDTO;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String index(Model model) {
        LoginDTO loginDTO = new LoginDTO();
        model.addAttribute("loginDTO", loginDTO);
        return "auth/login";
    }

}
