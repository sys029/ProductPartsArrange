package com.example.bibox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

public class CardViewHorizondal extends AppCompatActivity {

    MaterialCardView headPart;
    MaterialCardView bodyPart;
    MaterialCardView leftArm;
    MaterialCardView rightArm;
    MaterialCardView leftLeg;
    MaterialCardView rightLeg;

    LinearLayout parentLay;

    AppCompatButton nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_horizondal);

        parentLay = findViewById(R.id.cardViewParent);

        headPart = findViewById(R.id.head_cardview);
        bodyPart = findViewById(R.id.body_cardview);
        leftArm = findViewById(R.id.left_arm_cardview);
        rightArm = findViewById(R.id.right_arm_cardview);
        leftLeg = findViewById(R.id.left_leg_cardview);
        rightLeg = findViewById(R.id.right_leg_cardview);

        nextBtn = (AppCompatButton) findViewById(R.id.nextBt);

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

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                ///
                if (headPart.isChecked() == false && bodyPart.isChecked() == false && leftLeg.isChecked() == false && leftArm.isChecked() == false && rightLeg.isChecked() == false && rightArm.isChecked() == false ){
                    Snackbar.make(parentLay,"Select Parts to Continue",Snackbar.LENGTH_SHORT).show();

                }else {

                    Intent in = new Intent(getApplicationContext(),DragView.class);

                    if (headPart.isChecked()){
                        in.putExtra("headId", R.drawable.head);

                    }if (bodyPart.isChecked()){
                        in.putExtra("bodyId", R.drawable.body);

                    }
                    if (leftArm.isChecked()){
                        in.putExtra("leftaId", R.drawable.left_a);

                    }
                    if (rightArm.isChecked()){
                        in.putExtra("rightaId", R.drawable.right_a);

                    }
                    if (leftLeg.isChecked()){
                        in.putExtra("leftlId", R.drawable.left_l);

                    }if (rightLeg.isChecked()){
                        in.putExtra("rightlId", R.drawable.right_l);

                    }
                    startActivity(in);

                }



            }
        });
    }
}