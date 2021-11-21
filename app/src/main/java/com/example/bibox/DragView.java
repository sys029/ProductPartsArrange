package com.example.bibox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.card.MaterialCardView;

public class DragView extends AppCompatActivity {

    DraggableCoordinatorLayout parentLayout;
    Button dragviewButton;
    MaterialCardView draggableCard1,draggableCard2,draggableCard3,draggableCard4,draggableCard5,draggableCard6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_view);

        dragviewButton = findViewById(R.id.dragviewButton);

        draggableCard1 = findViewById(R.id.draggableCard1);
        draggableCard2 = findViewById(R.id.draggableCard2);
        draggableCard3 = findViewById(R.id.draggableCard3);
        draggableCard4 = findViewById(R.id.draggableCard4);
        draggableCard5 = findViewById(R.id.draggableCard5);
        draggableCard6 = findViewById(R.id.draggableCard6);

        parentLayout = findViewById(R.id.parentCoordinatorLayout);

        parentLayout.addDraggableChild(draggableCard1);
        parentLayout.addDraggableChild(draggableCard2);
        parentLayout.addDraggableChild(draggableCard3);
        parentLayout.addDraggableChild(draggableCard4);
        parentLayout.addDraggableChild(draggableCard5);
        parentLayout.addDraggableChild(draggableCard6);

        dragviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PaintActivity.class);
                startActivity(i);
            }
        });

        parentLayout.setViewDragListener(new DraggableCoordinatorLayout.ViewDragListener() {
            @Override
            public void onViewCaptured(@NonNull View view, int i) {
                switch (view.getId()){

                    case 0:
                       draggableCard1.setDragged(true);
                        break;
                    case 1:
                        draggableCard2.setDragged(true);
                        break;
                    case 2:
                        draggableCard3.setDragged(true);
                        break;
                    case 3:
                        draggableCard4.setDragged(true);
                        break;
                    case 4:
                        draggableCard5.setDragged(true);
                        break;
                    case 5:
                        draggableCard6.setDragged(true);


                }
            }

            @Override
            public void onViewReleased(@NonNull View view, float v, float v1) {

                switch (view.getId()){

                    case 0:
                        draggableCard1.setDragged(false);
                        break;
                    case 1:
                        draggableCard2.setDragged(false);
                        break;
                    case 2:
                        draggableCard3.setDragged(false);
                        break;
                    case 3:
                        draggableCard4.setDragged(false);
                        break;
                    case 4:
                        draggableCard5.setDragged(true);
                        break;
                    case 5:
                        draggableCard6.setDragged(true);

                }

            }
        });

    }
}