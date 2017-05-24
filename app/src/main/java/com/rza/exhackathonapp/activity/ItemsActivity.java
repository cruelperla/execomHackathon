package com.rza.exhackathonapp.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.rza.exhackathonapp.R;
import com.rza.exhackathonapp.adapter.ItemAdapter;
import com.rza.exhackathonapp.dao.ItemDao;
import com.rza.exhackathonapp.model.Item;


import java.util.ArrayList;
import java.util.List;


public class ItemsActivity extends AppCompatActivity {

    List<Item> items;
    ItemDao itemDao;
    ItemAdapter adapter;
    RecyclerView recyclerView;

    @Override
    public void onBackPressed() {
        //da se ne desi nista kad se stisne back
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        items = itemDao.createItems();
        adapter = new ItemAdapter(this, items);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ItemsActivity.this, AddNewItemActivity.class);
                //dodati extra za mejl
                startActivity(i);
                Toast.makeText(ItemsActivity.this, "Importovanje sa kamere stvarno radi, probajte! :)", Toast.LENGTH_LONG).show();
            }
        });





    }










}