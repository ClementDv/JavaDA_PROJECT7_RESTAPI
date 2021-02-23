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

    private BidListMapper bidListMapper;

    public BidListController(BidListService service, BidListMapper bidListMapper) {
        this.service = service;
        this.bidListMapper = bidListMapper;
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

    @PostMapping("/bidList/saveBid")
    public String validate(@ModelAttribute("bidList") @Valid BidListDto bidListDto) {
        service.create(bidListDto);
        return "redirect:/poseidon/bidList/list";
    }

    @GetMapping("/bidList/updateBid")
    public String showUpdateForm(@RequestParam Integer id, Model model) {
        model.addAttribute("bidListToUpdate",
                service.read(id));
        model.addAttribute("bidListDto", new BidListDto());
        return "bidList/update";
    }

    @PutMapping("/bidList/updateBid")
    public String updateBid(@RequestParam Integer id, @Valid @ModelAttribute BidListDto bidListDto) {
        service.update(id, bidListDto);
        return "redirect:/poseidon/bidList/list";
    }

    @DeleteMapping("/bidList/deleteBid")
    public String deleteBid(@RequestParam Integer id) {
        service.deleteById(id);
        return "redirect:/poseidon/bidList/list";
    }
}
