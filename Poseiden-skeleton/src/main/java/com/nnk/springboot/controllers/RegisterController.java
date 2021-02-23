package com.nnk.springboot.controllers;

import com.nnk.springboot.services.AuthenticationService;
import com.nnk.springboot.domain.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/poseidon/register")
public class RegisterController {

    private AuthenticationService authenticationService;

    public RegisterController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public ModelAndView showRegisterForm() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register/registerForm");
        mav.addObject("user", new UserDto());
        return mav;
    }

    @PostMapping
    public ModelAndView registerUser(@ModelAttribute("user") UserDto userDto) {
        ModelAndView mav = new ModelAndView();
        authenticationService.registerUser(userDto);
        mav.setViewName("redirect:register?success");
        return mav;
    }

}
