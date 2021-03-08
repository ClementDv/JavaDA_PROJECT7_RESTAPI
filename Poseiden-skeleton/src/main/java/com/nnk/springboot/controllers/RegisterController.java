package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.dto.UserDto;
import com.nnk.springboot.services.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/poseidon/register")
public class RegisterController {

    private final AuthenticationService authenticationService;

    public RegisterController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "register/registerForm";
    }

    @PostMapping
    public String registerUser(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            authenticationService.registerUser(user);
            return "redirect:register?success";
        }
        return "register/registerForm";
    }
}
