package com.example.mediaplayerlite;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button starting = findViewById(R.id.startservice);
        Button stoping = findViewById(R.id.stopservice);
        Button pausing = findViewById(R.id.pauseservice);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.tune);
        mp.setLooping(true);

        starting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        stoping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mp.stop();
                    mp.release();
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.tune);
                }
                catch (Exception e)
                {

                }
            }
        });
        pausing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mp.pause();
//                    mp = MediaPlayer.create(getApplicationContext(), R.raw.tune);
                }
                catch (Exception e)
                {

                }
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        try {
            mp.stop();
            mp.release();
        }
        catch (Exception e)
        {

        }
    }
}