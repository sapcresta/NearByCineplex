package com.example.sapana.nearbycineplex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class showingMovie4 extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener  {

    public static final String API_KEY = "AIzaSyD-o2fz9AyWTwmBvci9lvv565jCtip4W54";
    public static final String VIDEO_ID = "HyNJ3UrGk_I";
    TextView desc;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showing_movie2);
        /** Initializing YouTube Player View **/
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY, this);
        name=(TextView) findViewById(R.id.moviename);
        name.setText("THE EQUALIZER 2");
        desc=(TextView) findViewById(R.id.description);
        desc.setText("Robert McCall returns to deliver his special brand of vigilante justice when thugs kill his friend and former colleague.\n \n"+" Director: Antoine Fuqua\n" +
                "Based on: The Equalizer; by Michael Sloan \n"+"Genre: Crime film/Action \n"+"Length: 2hr 1min");
    }
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failured to Initialize!", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
/** add listeners to YouTubePlayer instance **/
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);
/** Start buffering **/
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }
    }
    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onBuffering(boolean arg0) {
        }
        @Override
        public void onPaused() {
        }
        @Override
        public void onPlaying() {
        }
        @Override
        public void onSeekTo(int arg0) {
        }
        @Override
        public void onStopped() {
        }
    };
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onAdStarted() {
        }
        @Override
        public void onError(YouTubePlayer.ErrorReason arg0) {
        }
        @Override
        public void onLoaded(String arg0) {
        }
        @Override
        public void onLoading() {
        }
        @Override
        public void onVideoEnded() {
        }
        @Override
        public void onVideoStarted() {
        }
    };
    public void bookmovie(View view) {
        Intent i = new Intent(this, Theatre_Show_List.class);
        startActivity(i);
    }

    public void reviewspage(View view) {
        Intent i = new Intent(this, Main4Activity.class);
        startActivity(i);
    }
}