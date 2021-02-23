package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.dto.RatingDto;
import com.nnk.springboot.domain.entity.Rating;
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
    public String validate(@Valid @ModelAttribute("rating") RatingDto ratingDto) {
        service.create(ratingDto);
        return "redirect:/poseidon/rating/list";
    }

    @GetMapping("/rating/updateRating")
    public String showUpdateForm(@RequestParam Integer id, Model model) {
        model.addAttribute("ratingToUpdate", service.read(id));
        model.addAttribute("ratingDto", new RatingDto());
        return "rating/update";
    }

    @PutMapping("/rating/updateRating")
    public String updateRating(@RequestParam Integer id, @Valid @ModelAttribute("ratingDto") RatingDto ratingDto) {
        service.update(id, ratingDto);
        return "redirect:/poseidon/rating/list";
    }

    @DeleteMapping("/rating/deleteRating")
    public String deleteRating(@RequestParam Integer id) {
        service.deleteById(id);
        return "redirect:/poseidon/rating/list";
    }
}
