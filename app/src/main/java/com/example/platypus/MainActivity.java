package com.example.platypus;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView platypusImageView;
    private MediaPlayer mediaPlayer;
    private boolean isPerryShown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        platypusImageView = findViewById(R.id.platypusImageView);
        mediaPlayer = MediaPlayer.create(this, R.raw.platypus_sound); // Add your platypus sound resource

        // You can also set an initial description for accessibility
        platypusImageView.setContentDescription(getString(R.string.platypus_description));

        // Start playing the platypus sound when the app starts
        mediaPlayer.start();
    }

    public void onPlatypusClick(View view) {
        if (isPerryShown) {
            platypusImageView.setImageResource(R.drawable.platypus); // Replace with your platypus image resource
            platypusImageView.setContentDescription(getString(R.string.platypus_description));
            mediaPlayer = MediaPlayer.create(this, R.raw.platypus_sound); // Add your platypus sound resource
        } else {
            platypusImageView.setImageResource(R.drawable.perry); // Replace with your Perry image resource
            platypusImageView.setContentDescription(getString(R.string.perry_description));
            mediaPlayer = MediaPlayer.create(this, R.raw.perry_sound); // Add your Perry sound resource
        }

        isPerryShown = !isPerryShown;
        mediaPlayer.start();
    }
}

