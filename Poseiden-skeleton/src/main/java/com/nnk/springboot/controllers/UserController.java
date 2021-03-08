package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.dto.UserDto;
import com.nnk.springboot.domain.dto.UserUpdateDto;
import com.nnk.springboot.domain.mapper.UserUpdateMapper;
import com.nnk.springboot.services.AuthenticationService;
import com.nnk.springboot.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/poseidon")
public class UserController {

    private final AuthenticationService authenticationService;

    private final UserService userService;

    private final BCryptPasswordEncoder encoder;

    private final UserUpdateMapper userUpdateMapper;

    public UserController(AuthenticationService authenticationService, UserService userService, BCryptPasswordEncoder encoder, UserUpdateMapper userUpdateMapper) {
        this.authenticationService = authenticationService;
        this.userService = userService;
        this.encoder = encoder;
        this.userUpdateMapper = userUpdateMapper;
    }

    @RequestMapping("/user/list")
    public String home(Model model) {
        System.out.println(userService.findAll());
        model.addAttribute("userList", userService.getList());
        return "user/list";
    }

    @GetMapping("/user/register")
    public String addUser(Model model) {
        model.addAttribute("user", new UserDto());
        return "user/register";
    }

    @PostMapping("/user/register")
    public String validate(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            authenticationService.registerUser(userDto);
            return "redirect:/poseidon/user/list";
        }
        else {
            return "user/register";
        }
    }

    @GetMapping("/user/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userUpdateMapper.toModel(userService.read(id)));
        return "user/update";
    }

    @PutMapping("/user/{id}")
    public String updateUser(@Valid @ModelAttribute("user") UserUpdateDto user, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (!user.getPassword().isEmpty()) {
                user.setPassword(encoder.encode(user.getPassword()));
            } else {
                user.setPassword(userService.read(user.getId()).getPassword());
            }
            userService.update(userUpdateMapper.fromModel(user));
            return "redirect:/poseidon/user/list";
        }
        else {
            return "user/update";
        }
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return "redirect:/poseidon/user/list";
    }
}
