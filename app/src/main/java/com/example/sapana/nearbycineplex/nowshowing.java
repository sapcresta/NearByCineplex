package com.example.sapana.nearbycineplex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class nowshowing extends AppCompatActivity {
    public ImageButton nsmovie1;
    public ImageButton nsmovie2;
    public ImageButton nsmovie3;
    public ImageButton nsmovie4;
    public void init(){
        nsmovie1=(ImageButton) findViewById(R.id.nshowingMovie1);
        nsmovie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nsmovie1=new Intent(nowshowing.this,showingMovie1.class);
                startActivity(nsmovie1);
            }
        });
        nsmovie2=(ImageButton) findViewById(R.id.nshowingMovie2);
        nsmovie2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nsmovie2=new Intent(nowshowing.this,showingMovie2.class);
                startActivity(nsmovie2);
            }
        });
        nsmovie3=(ImageButton) findViewById(R.id.nshowingMovie3);
        nsmovie3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nsmovie3=new Intent(nowshowing.this,showingMovie3.class);
                startActivity(nsmovie3);
            }
        });
        nsmovie4=(ImageButton) findViewById(R.id.nshowingMovie4);
        nsmovie4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nsmovie4=new Intent(nowshowing.this,showingMovie4.class);
                startActivity(nsmovie4);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowshowing);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        init();

    }
}
