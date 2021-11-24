package com.example.bibox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.card.MaterialCardView;

import java.io.ByteArrayOutputStream;

public class DragView extends AppCompatActivity {

    DraggableCoordinatorLayout parentLayout;
    AppCompatButton dragviewButton;
    MaterialCardView draggableCard1,draggableCard2,draggableCard3,draggableCard4,draggableCard5,draggableCard6;

    ImageView bodyImg,headImg,leftlImg,rightlImg,leftaImg,rightaImg;

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

        bodyImg =(ImageView)findViewById(R.id.bodyImg);
        headImg =(ImageView)findViewById(R.id.headImg);
        leftaImg =(ImageView)findViewById(R.id.leftaImg);
        rightaImg =(ImageView)findViewById(R.id.rightaImg);
        leftlImg =(ImageView)findViewById(R.id.leftlImg);
        rightlImg =(ImageView)findViewById(R.id.rightlImg);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int resId = bundle.getInt("bodyId");
            bodyImg.setImageResource(resId);
        }if (bundle != null) {
            int resId = bundle.getInt("headId");
            headImg.setImageResource(resId);
        }
        if (bundle != null) {
            int resId = bundle.getInt("leftaId");
            leftaImg.setImageResource(resId);
        }
        if (bundle != null) {
            int resId = bundle.getInt("rightaId");
            rightaImg.setImageResource(resId);
        }
        if (bundle != null) {
            int resId = bundle.getInt("leftlId");
            leftlImg.setImageResource(resId);
        }
        if (bundle != null) {
            int resId = bundle.getInt("rightlId");
            rightlImg.setImageResource(resId);
        }


        dragviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View contentView = getWindow().getDecorView().findViewById(R.id.parentCoordinatorLayout);
                contentView.setDrawingCacheEnabled(true);
                contentView.buildDrawingCache();
                Bitmap drawingCache = contentView.getDrawingCache();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                drawingCache.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] b = baos.toByteArray();

                Intent intent = new Intent(getApplicationContext(), PaintActivity.class);
                intent.putExtra("picture", b);
                startActivity(intent);


//                Intent i = new Intent(getApplicationContext(),PaintActivity.class);
//                i.put
//                startActivity(i);
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