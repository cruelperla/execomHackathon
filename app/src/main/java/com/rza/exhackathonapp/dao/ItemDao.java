package com.rza.exhackathonapp.dao;

import android.content.ClipData;
import android.widget.ArrayAdapter;

import com.rza.exhackathonapp.adapter.ItemAdapter;
import com.rza.exhackathonapp.model.Item;
import com.rza.exhackathonapp.model.User;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Rza on 22-May-17.
 */


public class ItemDao {

    public static ArrayList<Item> createItems() {
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            items.add(new Item("Item Name", "lorem ipsum","http://cdn.bgr.com/2012/11/android-icon.jpg?quality=98&strip=all", 23.23,
                    "username"));

        }
        return items;
    }

    /*

    public static List<Item> createItems() {
        List<Item> items = Item.listAll(Item.class);
        return items;
    }
     */
}
