package com.company.firesale.controllers;

import com.company.firesale.entity.Auction;
import com.company.firesale.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/action")
public class AuctionController {

    private AuctionService actionEntityServis;

    @Autowired
    public AuctionController(AuctionService actionEntityServis) {
        this.actionEntityServis = actionEntityServis;
    }

    @PostMapping
    Auction createActionEntity() {
        return actionEntityServis.createActionEntity();
    }

    @GetMapping("/{page}")
    List<Auction> getTenActionEntityOrderById(@PathVariable int page) {
        return actionEntityServis.findTenById(page).getContent();
    }

    @GetMapping("/date/{page}")
    List<Auction> getTenActionEntityOrderByDate(@PathVariable int page) {
        return actionEntityServis.findTenByDate(page).getContent();
    }
}
