package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("add")
    public String displayAddUserForm() {

        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user,@RequestParam String verify) {
        // add form submission handling code here
        if (user.getPassword().equals(verify)) {
            model.addAttribute("user", user);
            return "user/index";
        }
        String error = "error";
        model.addAttribute("error", error);
        return "user/add";
    }
}
