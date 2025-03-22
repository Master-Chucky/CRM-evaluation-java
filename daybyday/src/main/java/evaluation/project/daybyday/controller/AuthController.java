package evaluation.project.daybyday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import evaluation.project.daybyday.dto.LoginDTO;
import evaluation.project.daybyday.service.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/process-login")
    public String processLogin(@ModelAttribute("loginDTO") LoginDTO data) {
        return authService.authenticate(data.getEmail(), data.getPasse());
    }

}

