package com.example.bibox;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class FinishActivity extends AppCompatActivity {

    ImageView finalImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        finalImg = findViewById(R.id.finalImage);

        Bundle extras = getIntent().getExtras();
        byte[] b = extras.getByteArray("finalpic");

        Bitmap bmp = BitmapFactory.decodeByteArray(b, 0, b.length);

        finalImg.setImageBitmap(bmp);


    }
}