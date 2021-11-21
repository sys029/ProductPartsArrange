package com.example.bibox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class CardViewHorizondal extends AppCompatActivity {

    MaterialCardView headPart;
    MaterialCardView bodyPart;
    MaterialCardView leftArm;
    MaterialCardView rightArm;
    MaterialCardView leftLeg;
    MaterialCardView rightLeg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_horizondal);

        headPart = findViewById(R.id.head_cardview);
        bodyPart = findViewById(R.id.body_cardview);
        leftArm = findViewById(R.id.left_arm_cardview);
        rightArm = findViewById(R.id.right_arm_cardview);
        leftLeg = findViewById(R.id.left_leg_cardview);
        rightLeg = findViewById(R.id.right_leg_cardview);

        headPart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               headPart.toggle();
            }
        });

        bodyPart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bodyPart.toggle();
            }
        });

        leftLeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftLeg.toggle();
            }
        });

        rightLeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightLeg.toggle();
            }
        });

        leftArm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftArm.toggle();
            }
        });

        rightArm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightArm.toggle();
            }
        });
    }
}