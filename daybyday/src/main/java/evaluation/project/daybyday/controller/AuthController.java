package evaluation.project.daybyday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import evaluation.project.daybyday.dto.LoginDTO;
import evaluation.project.daybyday.service.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/process-login")
    public String processLogin(@ModelAttribute("loginDTO") LoginDTO data, Model model) {
        LoginDTO loginDTO = new LoginDTO();
        try {
            String token = authService.login(data.getEmail(), data.getPassword());
            if (token != null) {
                model.addAttribute("message", "Connexion réussie !");
                model.addAttribute("loginDTO", loginDTO);
                return "auth/login";
            } else {
                model.addAttribute("errorMessage", "Identifiants incorrects.");
                model.addAttribute("loginDTO", loginDTO);
                return "auth/login";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

