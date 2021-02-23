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
    public String home(Model model)
    {
        model.addAttribute("curveList", service.getList());
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(Model model) {
        model.addAttribute("curvePoint", new CurvePointDto());
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/saveCurve")
    public String validate(@Valid @ModelAttribute("curvePoint") CurvePointDto curvePointDto) {
        service.create(curvePointDto);
        return "redirect:/poseidon/curvePoint/list";
    }

    @GetMapping("/curvePoint/updateCurve")
    public String showUpdateForm(@RequestParam Integer id, Model model) {
        System.out.println(service.read(id));
        model.addAttribute("curvePointToUpdate", service.read(id));
        model.addAttribute("curvePointDto", new CurvePointDto());
        return "curvePoint/update";
    }

    @PutMapping("/curvePoint/updateCurve")
    public String updateBid(@RequestParam Integer id, @Valid @ModelAttribute("curvePointDto") CurvePointDto curvePointDto) {
        service.update(id, curvePointDto);
        return "redirect:/poseidon/curvePoint/list";
    }

    @DeleteMapping("/curvePoint/deleteCurve")
    public String deleteBid(@RequestParam Integer id) {
        service.deleteById(id);
        return "redirect:/poseidon/curvePoint/list";
    }
}
