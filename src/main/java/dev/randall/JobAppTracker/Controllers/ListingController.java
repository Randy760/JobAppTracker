package dev.randall.JobAppTracker.Controllers;

import dev.randall.JobAppTracker.Models.Listing;
import dev.randall.JobAppTracker.Services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/listings")
public class ListingController {

    @Autowired
    private ListingService listingService;

    @GetMapping
    public ResponseEntity<List<Listing>> getAllListingItems() {
        return new ResponseEntity<>(listingService.getAllAvailableListings(), HttpStatus.OK);
    }

    @DeleteMapping("/{companyName}")
    public ResponseEntity<String> deleteListingItem(@PathVariable String companyName) {
        return new ResponseEntity<>(listingService.deleteSpecificListing(companyName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Listing> createNewListingItem(@RequestBody Map<String, String> payload) {

        return new ResponseEntity<>(listingService.createListing(payload), HttpStatus.CREATED);
    }
}
