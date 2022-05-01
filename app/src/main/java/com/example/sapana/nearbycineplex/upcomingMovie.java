package com.example.sapana.nearbycineplex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class upcomingMovie extends AppCompatActivity {
    public ImageButton upmovie1;
    public ImageButton upmovie2;
    public ImageButton upmovie3;
    public ImageButton upmovie4;
    public void init(){
        upmovie1=(ImageButton) findViewById(R.id.upcomMovie1);
        upmovie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent upmovie1=new Intent(upcomingMovie.this,upcomingMovie1.class);
                startActivity(upmovie1);
            }
        });
        upmovie2=(ImageButton) findViewById(R.id.upcomMovie2);
        upmovie2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent upmovie2=new Intent(upcomingMovie.this,upcomingMovie2.class);
                startActivity(upmovie2);
            }
        });
        upmovie3=(ImageButton) findViewById(R.id.upcomMovie3);
        upmovie3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent upmovie3=new Intent(upcomingMovie.this,upcomingMovie3.class);
                startActivity(upmovie3);
            }
        });
        upmovie4=(ImageButton) findViewById(R.id.upcomMovie4);
        upmovie4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent upmovie4=new Intent(upcomingMovie.this,upcomingMovie4.class);
                startActivity(upmovie4);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_movie);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        init();
    }
}
