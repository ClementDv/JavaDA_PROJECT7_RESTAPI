package com.nnk.springboot.controllers.api;


import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.services.BidListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bidlist")
public class BidListApiController {
    private final BidListService service;

    public BidListApiController(BidListService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<BidList> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public BidList findOne(@PathVariable("id") Integer id) {
        return service.getOne(id);
    }

    @PostMapping("/")
    public BidList insert(@RequestBody BidList toUpdate) {
        return service.save(toUpdate);
    }

    @PutMapping("/{id}")
    public BidList update(@PathVariable("id") Integer id, @RequestBody BidList toUpdate) {
        return service.save(toUpdate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }
}
