package com.example.bibox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import static com.example.bibox.display.current_brush;
import static com.example.bibox.display.colorList;
import static com.example.bibox.display.pathList;

import java.io.ByteArrayOutputStream;


public class PaintActivity extends AppCompatActivity {

    public static Path path = new Path();
    public static Paint paint_brush = new Paint();

    Button finishButton;

    View disp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        finishButton = findViewById(R.id.finishButton);

        disp = findViewById(R.id.paintDisplay);

        Bundle extras = getIntent().getExtras();
        byte[] b = extras.getByteArray("picture");

        Bitmap bmp = BitmapFactory.decodeByteArray(b, 0, b.length);
        Drawable dr = new BitmapDrawable(bmp);
       disp.setBackgroundDrawable(dr);

       finishButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               View contentView = getWindow().getDecorView().findViewById(R.id.constraintLayout2);
               contentView.setDrawingCacheEnabled(true);
               contentView.buildDrawingCache();
               Bitmap drawingCache = contentView.getDrawingCache();

               ByteArrayOutputStream baos = new ByteArrayOutputStream();
               drawingCache.compress(Bitmap.CompressFormat.PNG, 100, baos);
               byte[] b = baos.toByteArray();

               Intent intent = new Intent(getApplicationContext(), FinishActivity.class);
               intent.putExtra("finalpic", b);
               startActivity(intent);
           }
       });
    }

    public void eraser(View view){
        pathList.clear();
        colorList.clear();
        path.reset();

    }

    public void pencil(View view){
        paint_brush.setColor(Color.BLACK);
        currentColor(paint_brush.getColor());

    }

    public void redColor(View view){
        paint_brush.setColor(Color.RED);
        currentColor(paint_brush.getColor());

    }
    public void yellowColor(View view){
        paint_brush.setColor(Color.YELLOW);
        currentColor(paint_brush.getColor());

    }
    public void magentaColor(View view){
        paint_brush.setColor(Color.MAGENTA);
        currentColor(paint_brush.getColor());

    }
    public void greenColor(View view){
        paint_brush.setColor(Color.GREEN);
        currentColor(paint_brush.getColor());

    }
    public void currentColor(int c){
        current_brush = c;
        path = new Path();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        pathList.clear();
        colorList.clear();
        path.reset();


    }
}