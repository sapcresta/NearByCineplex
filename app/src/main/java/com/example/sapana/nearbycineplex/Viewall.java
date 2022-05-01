package com.example.sapana.nearbycineplex;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.sapana.nearbycineplex.model.DataModel;
import com.example.sapana.nearbycineplex.sql.DatabaseHelper1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csa on 3/1/2017.
 */

public class Viewall extends Activity {

    // Button show;
    DatabaseHelper1 database;
    RecyclerView recyclerView;
    RecycleAdapter recycler;
    List<DataModel> datamodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
       // show = (Button) findViewById(R.id.view);
        datamodel =new ArrayList<DataModel>();
        recyclerView = (RecyclerView) findViewById(R.id.recycle);


       // show.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
                database = new DatabaseHelper1(Viewall.this);
                datamodel=  database.getdata();
                recycler =new RecycleAdapter(datamodel);


                Log.i("HIteshdata",""+datamodel);
                RecyclerView.LayoutManager reLayoutManager =new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(reLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(recycler);


         //   }
     //   });

    }
}
