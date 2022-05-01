package com.example.sapana.nearbycineplex;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class upcomingMovie3 extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
        public static final String API_KEY = "AIzaSyD-o2fz9AyWTwmBvci9lvv565jCtip4W54";
        public static final String VIDEO_ID = "Pcv0aoOlsLM";
        TextView desc;
        TextView name;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_upcoming_movie3);
            /** Initializing YouTube Player View **/
            YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
            youTubePlayerView.initialize(API_KEY, this);
            name=(TextView)findViewById(R.id.moviename);
            name.setText("GOLD");
            desc=(TextView) findViewById(R.id.description);
            desc.setText("Gold set in 1948 tells the historic story of the Hockey team that won the first Olympic medal for India as a free nation on the 12th of August 1948. Gold is an inspirational story of a team that fought against all odds to bring their nation hope, pride and respect. \n \n"+"Genre: Drama/Biography \n"+"Release Date: August 15, 2018");
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
}
