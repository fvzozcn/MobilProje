package com.example.odevtekrar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    TextView txt1;
    ImageView img;
    Animation anim1, anim2;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.txt1);
        img = findViewById(R.id.imageView);
        anim2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim2);
        anim1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim1);
        txt1.startAnimation(anim1);
        img.startAnimation(anim2);
        anim2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (InternetKontrol()) {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(i);
                    finish();
                } else {
                    finish();

                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }

    public boolean InternetKontrol() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(MainActivity.CONNECTIVITY_SERVICE);
        if (manager.getActiveNetworkInfo() != null
                && manager.getActiveNetworkInfo().isAvailable()
                && manager.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }
}