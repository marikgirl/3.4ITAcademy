package com.example.mightypicture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.net.URL;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Bitmap myBitmap;
    URL url;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);

        Thread new_thread = new Thread() {
            public void run() {
                try {
                    myBitmap = BitmapFactory.decodeStream(new URL("http://www.bbc.co.uk/staticarchive/1ef3ac2fcffd815911fcfe68f6d8d97b5f6b1a15.jpg").openStream());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        new_thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        imageView.setImageBitmap(myBitmap);
    }
}
