package com.rza.exhackathonapp.model;

import com.orm.SugarRecord;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Rza on 21-May-17.
 */

public class Item extends SugarRecord<Item> {

    int id;
    String itemName;
    String itemDesc;
    double itemPrice;
    String currentDateTimeString;
    String photoUrl;
    String userEmail;


    public Item(int id, String itemName, String itemDesc, String photoUrl, double itemPrice, String userEmail) {
        this.id = id;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemPrice = itemPrice;
        currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        this.photoUrl = photoUrl;
        this.userEmail = userEmail;
    }

    public Item(String itemName, String itemDesc, String photoUrl, double itemPrice, String userEmail) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemPrice = itemPrice;
        currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        this.photoUrl = photoUrl;
        this.userEmail = userEmail;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getCurrentDateTimeString() {
        return currentDateTimeString;
    }

    public void setCurrentDateTimeString(String currentDateTimeString) {
        this.currentDateTimeString = currentDateTimeString;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("itemName='").append(itemName).append('\'');
        sb.append(", itemDesc='").append(itemDesc).append('\'');
        sb.append(", itemPrice=").append(itemPrice);
        sb.append(", photoUrl='").append(photoUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
