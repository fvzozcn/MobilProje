package com.example.odevtekrar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class vwplayer extends AppCompatActivity {
    VideoView vw;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vwplayer);
        mediaController=new MediaController(vwplayer.this);
        try {

            vw=findViewById(R.id.vw);
            Intent g=getIntent();
            String data = g.getStringExtra("vw");
            vw.setVideoPath(data);
            vw.setMediaController(mediaController);
            vw.start();

        }
       catch (Exception e)
       {
           Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
       }


        }
    }
