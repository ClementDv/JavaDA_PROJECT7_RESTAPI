package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.dto.RatingDto;
import com.nnk.springboot.services.RatingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/poseidon")
public class RatingController {

    private final RatingService service;

    public RatingController(RatingService service) {
        this.service = service;
    }

    @RequestMapping("/rating/list")
    public String home(Model model) {
        model.addAttribute("ratingList", service.getList());
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Model model) {
        model.addAttribute("rating", new RatingDto());
        return "rating/add";
    }

    @PostMapping("/rating/saveRating")
    public String validate(@Valid @ModelAttribute("rating") RatingDto ratingDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            service.create(ratingDto);
            return "redirect:/poseidon/rating/list";
        }
        else {
            return "rating/add";
        }
    }

    @GetMapping("/rating/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("rating", service.read(id));
        return "rating/update";
    }

    @PutMapping("/rating/{id}")
    public String updateRating(@Valid @ModelAttribute("rating") RatingDto ratingDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            service.update(ratingDto);
            return "redirect:/poseidon/rating/list";
        }
        else {
            return "rating/update";
        }
    }

    @DeleteMapping("/rating/{id}")
    public String deleteRating(@PathVariable("id") Integer id) {
        service.deleteById(id);
        return "redirect:/poseidon/rating/list";
    }
}
