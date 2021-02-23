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

    @PostMapping("/trade/saveTrade")
    public String validate(@Valid @ModelAttribute TradeDto tradeDto) {
        service.create(tradeDto);
        return "redirect:/poseidon/trade/list";
    }

    @GetMapping("/trade/updateTrade")
    public String showUpdateForm(@RequestParam Integer id, Model model) {
        model.addAttribute("tradeToUpdate", service.read(id));
        model.addAttribute("tradeDto", new TradeDto());
        return "trade/update";
    }

    @PutMapping("/trade/updateTrade")
    public String updateTrade(@RequestParam Integer id, @Valid @ModelAttribute("tradeDto") TradeDto tradeDto) {
        service.update(id, tradeDto);
        return "redirect:/poseidon/trade/list";
    }

    @DeleteMapping("/trade/deleteTrade")
    public String deleteTrade(@RequestParam Integer id) {
        service.deleteById(id);
        return "redirect:/poseidon/trade/list";
    }
}
