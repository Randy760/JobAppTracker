package dev.randall.JobAppTracker.Services;

import dev.randall.JobAppTracker.Models.Listing;
import dev.randall.JobAppTracker.Repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ListingService {
    @Autowired
    private ListingRepository listingRepository;

    public List<Listing> getAllAvailableListings() {
        return listingRepository.getAllListings();
    }

    public String deleteSpecificListing(String companyName) {
        Listing listingToDelete = new Listing();
        listingToDelete.setCompanyName(companyName);
        listingRepository.delete(listingToDelete);
        return "That listing has now been deleted!";
    }

    public Listing createListing(Map<String, String> payload) {
        if (checkForExistingListing(payload.get("companyName"))) {
            return new Listing();
        }
        Listing listingToCreate;
        try {
            listingToCreate = createListingFromPayload(payload);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listingRepository.save(listingToCreate);
    }

    //All fields will be non-null and checked for values before reaching this method.
    private Listing createListingFromPayload(Map<String, String> payload) {
        Listing newListing = new Listing();
        newListing.setCompanyName(payload.get("companyName"));
        newListing.setPosNumber(payload.get("posNumber"));
        newListing.setPosition(payload.get("position"));
        newListing.setHasLogin(Boolean.getBoolean(payload.get("hasLogin")));
        newListing.setUsername(payload.get("username"));
        newListing.setPassword(payload.get("password"));
        return newListing;
    }

    private boolean checkForExistingListing(String companyName) {
        Listing findListing = new Listing();
        findListing.setCompanyName(companyName);
        return !Objects.isNull(listingRepository.load(findListing));
    }
}
