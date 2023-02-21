package dev.randall.JobAppTracker.Models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "AppListings")
public class Listing {

    @DynamoDBAttribute(attributeName = "positionNumber")
    private String posNumber;

    @DynamoDBHashKey
    @DynamoDBAttribute(attributeName = "companyName")
    private String companyName;

    @DynamoDBAttribute(attributeName = "position")
    private String position;

    @DynamoDBAttribute(attributeName = "hasLogin")
    private boolean hasLogin;

    @DynamoDBAttribute(attributeName = "username")
    private String username;

    @DynamoDBAttribute(attributeName = "password")
    private String password;

    public String getPosNumber() {
        return posNumber;
    }

    public void setPosNumber(String posNumber) {
        this.posNumber = posNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isHasLogin() {
        return hasLogin;
    }

    public void setHasLogin(boolean hasLogin) {
        this.hasLogin = hasLogin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
