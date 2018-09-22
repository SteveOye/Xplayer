package com.example.android.xplayer;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlaying extends AppCompatActivity implements View.OnClickListener{

    ImageView back;
    ImageButton play, pause, next, previous;
    ImageView favorite;
    SeekBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //calling methods
        initButton();
        details();
    }

    //init buttons and views
    private void initButton(){
        back = findViewById(R.id.back);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        progress = findViewById(R.id.progress);
        favorite = findViewById(R.id.favorite);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);

        back.setOnClickListener(this);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        favorite.setOnClickListener(this);
        next.setOnClickListener(this);
        previous.setOnClickListener(this);
    }

    //implementing the onclick method
    /*
     *the back listener send the user to the playlist activity
     *the play listener starts the animation and makes the ImageButton Play GONE
     *and set the ImageButton pause to be visible
     *the pause listener stops the animation and makes the ImageButton Pause GONE
     *and set the ImageButton play to be visible
     *changes the image of favorite to a red heart and display a toast
     * Favorite listener changes the image to a red heart from drawable when click
    */
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                Intent intent = new Intent(NowPlaying.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.play:
                play.setVisibility(View.GONE);
                pause.setVisibility(View.VISIBLE);
                break;
            case R.id.pause:
                play.setVisibility(View.VISIBLE);
                pause.setVisibility(View.GONE);
                break;
            case R.id.next:
                Toast.makeText(getApplicationContext(), "Next", Toast.LENGTH_LONG).show();
                break;
            case R.id.previous:
                Toast.makeText(getApplicationContext(), "Pervious", Toast.LENGTH_LONG).show();
                break;
            case R.id.favorite:
                favorite.setImageResource(R.drawable.favorite_red);
                Toast.makeText(getApplicationContext(), "Added to Favorite", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //method for the value pass from the mainActivity
    public void details() {
        /*
         *getting the trackname, artistname and duration of each track from the mainactivity
         * and passing it to textView on the Now Playing activity
         */
        final Intent info = getIntent();
        final Playlist playlist = info.getParcelableExtra("playlist");

        int trackArt = playlist.getTrackArt();
        String trackTitle = playlist.getTrackTitle();
        String artistName = playlist.getArtistName();
        String trackDuration = playlist.getTrackDuration();

        RelativeLayout relativeLayout = findViewById(R.id.relativeLayout);
        relativeLayout.setBackgroundResource(trackArt);

        final TextView titlePlaying = findViewById(R.id.title_playing);
        titlePlaying.setText(trackTitle);

        TextView artistPlaying = findViewById(R.id.artist_playing);
        artistPlaying.setText(artistName);

        TextView durationPlaying = findViewById(R.id.duration_playing);
        durationPlaying.setText(trackDuration);
    }
}
