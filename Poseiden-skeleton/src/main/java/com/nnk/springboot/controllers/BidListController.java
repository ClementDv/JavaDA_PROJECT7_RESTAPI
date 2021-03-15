package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.dto.BidListDto;
import com.nnk.springboot.domain.entity.BidList;
import com.nnk.springboot.domain.mapper.BidListMapper;
import com.nnk.springboot.services.BidListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/poseidon")
public class BidListController {
    private final BidListService service;

    public BidListController(BidListService service) {
        this.service = service;
    }

    @RequestMapping("/bidList/list")
    public String home(Model model) {
        model.addAttribute("bidList", service.getList());
        return "bidList/list";
    }

    @GetMapping("/bidList/add")
    public String addBidForm(Model model) {
        model.addAttribute("bidList", new BidListDto());
        return "bidList/add";
    }

    @PostMapping("/bidList/save")
    public String validate(@Valid @ModelAttribute("bidList") BidListDto bidListDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            service.create(bidListDto);
            return "redirect:/poseidon/bidList/list";
        } else {
            return "bidList/add";
        }
    }

    @GetMapping("/bidList/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("bidList", service.read(id));
        return "bidList/update";
    }

    @PutMapping("/bidList/{id}")
    public String updateBid(@Valid @ModelAttribute("bidList") BidListDto bidListDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            service.update(bidListDto);
            return "redirect:/poseidon/bidList/list";
        } else {
            return "bidList/update";
        }
    }

    @DeleteMapping("/bidList/{id}")
    public String deleteBid(@PathVariable("id") Integer id) {
        service.deleteById(id);
        return "redirect:/poseidon/bidList/list";
    }
}
