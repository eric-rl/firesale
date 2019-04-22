package com.company.firesale.controller;

import com.company.firesale.entity.Auction;
import com.company.firesale.json_classes.TestAuctionJsonClass;
import com.company.firesale.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/action")
public class AuctionController {

    private AuctionService actionEntityServis;

    @Autowired
    public AuctionController(AuctionService actionEntityServis) {
        this.actionEntityServis = actionEntityServis;
    }

    @PostMapping
    Auction createActionEntity(@RequestBody TestAuctionJsonClass auction, Principal principal) {
        return actionEntityServis.createNewAuction(auction, principal.getName());
    }

    @GetMapping("/{page}")
    List<Auction> getTenActionEntityOrderById(@PathVariable int page) {
        return actionEntityServis.findTenById(page).getContent();
    }

    @GetMapping("/date/{page}")
    List<Auction> getTenActionEntityOrderByDate(@PathVariable int page) {
        return actionEntityServis.findTenByDate(page).getContent();
    }

    @GetMapping("/id/{id}")
    Optional<Auction> getAuctionById(@PathVariable long id) {
        return actionEntityServis.findById(id);
    }

}
