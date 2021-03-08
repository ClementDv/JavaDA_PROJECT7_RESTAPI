package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.dto.BidListDto;
import com.nnk.springboot.domain.dto.RuleNameDto;
import com.nnk.springboot.domain.entity.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.services.RuleNameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/poseidon")
public class RuleNameController {

    private final RuleNameService service;

    public RuleNameController(RuleNameService service) {
        this.service = service;
    }

    @RequestMapping("/ruleName/list")
    public String home(Model model) {
        model.addAttribute("ruleNameList", service.getList());
        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(Model model) {
        model.addAttribute("ruleName", new RuleNameDto());
        return "ruleName/add";
    }

    @PostMapping("/ruleName/saveRuleName")
    public String validate(@Valid @ModelAttribute("ruleName") RuleNameDto ruleNameDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            service.create(ruleNameDto);
            return "redirect:/poseidon/ruleName/list";
        }
        else {
            return "ruleName/add";
        }
    }

    @GetMapping("/ruleName/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("ruleName", service.read(id));
        return "ruleName/update";
    }

    @PutMapping("/ruleName/{id}")
    public String updateRuleName(@Valid @ModelAttribute("ruleName") RuleNameDto ruleNameDto,
                                 BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            service.update(ruleNameDto);
            return "redirect:/poseidon/ruleName/list";
        }
        else {
            return "ruleName/update";
        }
    }

    @DeleteMapping("/ruleName/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id) {
        service.deleteById(id);
        return "redirect:/poseidon/ruleName/list";
    }
}
