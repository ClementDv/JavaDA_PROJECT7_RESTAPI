package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.dto.CurvePointDto;
import com.nnk.springboot.domain.entity.CurvePoint;
import com.nnk.springboot.services.CurvePointService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import javax.validation.Valid;

@Controller
@RequestMapping("/poseidon")
public class CurveController {

    private final CurvePointService service;

    public CurveController(CurvePointService service) {
        this.service = service;
    }

    @RequestMapping("/curvePoint/list")
    public String home(Model model) {
        model.addAttribute("curveList", service.getList());
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(Model model) {
        model.addAttribute("curvePoint", new CurvePointDto());
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/save")
    public String validate(@Valid @ModelAttribute("curvePoint") CurvePointDto curvePointDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            service.create(curvePointDto);
            return "redirect:/poseidon/curvePoint/list";
        } else {
            return "curvePoint/add";
        }
    }

    @GetMapping("/curvePoint/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("curvePoint", service.read(id));
        return "curvePoint/update";
    }

    @PutMapping("/curvePoint/{id}")
    public String updateBid(@Valid @ModelAttribute("curvePoint") CurvePointDto curvePointDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            service.update(curvePointDto);
            return "redirect:/poseidon/curvePoint/list";
        } else {
            return "curvePoint/update";
        }
    }

    @DeleteMapping("/curvePoint/{id}")
    public String deleteBid(@PathVariable("id") Integer id) {
        service.deleteById(id);
        return "redirect:/poseidon/curvePoint/list";
    }
}
