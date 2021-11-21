package com.example.bibox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bibox.HelperClass.AdapterParts;
import com.example.bibox.HelperClass.PartsHelper;

import java.util.ArrayList;

public class ItemScrollView extends AppCompatActivity implements AdapterParts.ListItemClickListener {

    RecyclerView partsRecycler;
    RecyclerView.Adapter adapter;
    Button continueBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_scroll_view);

        partsRecycler = findViewById(R.id.my_recycler);
        partsRecycler();

        continueBt = findViewById(R.id.continueButton);

        continueBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),DragView.class);
                startActivity(i);
            }
        });

    }

    private void partsRecycler() {


        partsRecycler.setHasFixedSize(true);
        partsRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<PartsHelper> partlocations = new ArrayList<>();
        partlocations.add(new PartsHelper( R.drawable.head, "HEAD"));
        partlocations.add(new PartsHelper( R.drawable.body, "BODY"));
        partlocations.add(new PartsHelper( R.drawable.left_a, "LEFT ARM"));
        partlocations.add(new PartsHelper( R.drawable.right_a, "RIGHT ARM"));

        partlocations.add(new PartsHelper( R.drawable.left_l, "LEFT LEG"));
        partlocations.add(new PartsHelper( R.drawable.right_l, "RIGHT LEG"));


        adapter = new AdapterParts(partlocations,this);
        partsRecycler.setAdapter(adapter);

    }


    @Override
    public void onPartsListClick(int clickedItemIndex) {


    }
}