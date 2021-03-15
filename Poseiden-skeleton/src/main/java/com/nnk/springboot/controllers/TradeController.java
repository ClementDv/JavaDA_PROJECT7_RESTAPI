package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.dto.TradeDto;
import com.nnk.springboot.domain.entity.Trade;
import com.nnk.springboot.services.TradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/poseidon")
public class TradeController {

    private final TradeService service;

    public TradeController(TradeService service) {
        this.service = service;
    }

    @RequestMapping("/trade/list")
    public String home(Model model) {
        model.addAttribute("tradeList", service.getList());
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(Model model) {
        model.addAttribute("trade", new TradeDto());
        return "trade/add";
    }

    @PostMapping("/trade/save")
    public String validate(@Valid @ModelAttribute("trade") TradeDto tradeDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            service.create(tradeDto);
            return "redirect:/poseidon/trade/list";
        } else {
            return "trade/add";
        }
    }

    @GetMapping("/trade/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("trade", service.read(id));
        return "trade/update";
    }

    @PutMapping("/trade/{id}")
    public String updateTrade(@Valid @ModelAttribute("trade") TradeDto tradeDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            service.update(tradeDto);
            return "redirect:/poseidon/trade/list";
        } else {
            return "trade/update";
        }
    }

    @DeleteMapping("/trade/{id}")
    public String deleteTrade(@PathVariable("id") Integer id) {
        service.deleteById(id);
        return "redirect:/poseidon/trade/list";
    }
}
