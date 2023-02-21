package dev.randall.JobAppTracker.Repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AmazonDynamoDBException;
import dev.randall.JobAppTracker.Models.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListingRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Listing save(Listing listing) {
        try {
            dynamoDBMapper.save(listing);
            // Get the newly saved listing to be returned instead of the listing provided.
            return load(listing);
        } catch (AmazonDynamoDBException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Listing listing) {
        try {
            dynamoDBMapper.delete(listing);
        } catch (AmazonDynamoDBException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Listing> getAllListings() {
        try {
            return dynamoDBMapper.scan(Listing.class, new DynamoDBScanExpression());
        } catch (AmazonDynamoDBException e) {
            throw new RuntimeException(e);
        }
    }

    public Listing load(Listing listingToGet) {
        try {
            return dynamoDBMapper.load(listingToGet);
        } catch (AmazonDynamoDBException e) {
            throw new RuntimeException(e);
        }
    }
}
