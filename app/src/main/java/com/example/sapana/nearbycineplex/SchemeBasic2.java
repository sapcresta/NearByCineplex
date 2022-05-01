package com.example.sapana.nearbycineplex;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.sapana.nearbycineplex.hall.HallScheme;
import com.example.sapana.nearbycineplex.hall.Seat;
import com.example.sapana.nearbycineplex.hall.SeatListener;
import com.example.sapana.nearbycineplex.sql.halldatabase;
import com.example.sapana.nearbycineplex.view.ZoomableImageView;

/**
 * Created by Nublo on 05.12.2015.
 * Copyright Nublo
 */
public class SchemeBasic2 extends Fragment implements View.OnClickListener {
    public  static int counter=0;
    Button nextfood;
    Communicator comm;
   //Communicator2 comm2;
    halldatabase hdb;
    public static int id12;
    public static String status12;
    public static int id122;
    public static String status122;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        hdb=new halldatabase(getActivity());
        View rootView = inflater.inflate(R.layout.basic_scheme_fragment, container, false);
        ZoomableImageView imageView = (ZoomableImageView) rootView.findViewById(R.id.zoomable_image);
        HallScheme scheme = new HallScheme(imageView, basicScheme2(), getActivity());
        scheme.setSeatListener(new SeatListener() {

            @Override
            public void selectSeat(int id) {  //HallScheme.SeatStatus status
                comm.respond(id);
                //comm2.respond1(id);
                counter++;
                Toast.makeText(getActivity(), " select seat "+ id +" total seat:"+counter, Toast.LENGTH_SHORT).show();
               saveCounter(counter);

            }

            @Override
            public void unSelectSeat(int id) {
                counter--;
                Toast.makeText(getActivity(), " Unselect seat "+ id +" total seat:"+counter, Toast.LENGTH_SHORT).show();
                saveCounter(counter); }

        });
        return rootView;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        nextfood=(Button)getActivity().findViewById(R.id.nextfood);
        nextfood.setOnClickListener(this);
        comm=(Communicator)getActivity();
       //comm2=(Communicator2)getActivity();
        Log.d("dit","onActivityCreated called");

    }

    public void saveCounter(int count){

        Integer value=count;
        String res=value.toString();
        android.content.SharedPreferences sharedPreferences=this.getActivity().getSharedPreferences("mydata", android.content.Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("counterValue",res);
        editor.commit();
        Toast.makeText(this.getActivity(),"saving counter successful with count="+count,Toast.LENGTH_SHORT).show();

    }

    public Seat[][] basicScheme2() {
        Seat seats[][] = new Seat[15][15];
        for (int i=0; i<15; i++) //rows
            for(int j =0; j<15; j++) {
                SeatExample seat = new SeatExample();
                seat.id = i * 15 + (j+1);
                seat.selectedSeatMarker = String.valueOf(j+1);
                seat.status = HallScheme.SeatStatus.EMPTY;
                seats[i][j] = seat;
                if (i >= 0 && i < 15) { //bujhyo  1st four row free
                    seat.status = HallScheme.SeatStatus.BUSY;
                    if(i==0)
                        seat.status= HallScheme.SeatStatus.BOOKED;
                    if(i==1)
                        seat.status= HallScheme.SeatStatus.BOOKED;
                    if (i>=4 && j>=2 &&j<14) {
                        seat.status = HallScheme.SeatStatus.FREE;
                        seat.color = Color.argb(255, 60, 179, 113); //changes
                        Cursor res = hdb.getalldata1();

                        if (res.getCount() == 0) {
                            //seat.status = HallScheme.SeatStatus.FREE;
                            Log.d("dit", "nothinggg");

                        } else {
                            while (res.moveToNext()) {
                                id12 = res.getInt(0);
                                status12 = res.getString(1);
                                if (seat.id == id12 && status12.equalsIgnoreCase("BOOKED")) {
                                    // HallScheme.SeatStatus.canSeatBePressed(HallScheme.SeatStatus.BOOKED);
                                    seat.status = HallScheme.SeatStatus.BOOKED;
                                    Log.d("dit", "hello world 2");
                                }
                       /*         else if(seat.id==id12 && status12.equalsIgnoreCase("BUSY"))
                                {
                                    seat.status = HallScheme.SeatStatus.BUSY;
                                }
                                else
                                {
                                  Log.d("dit","nothingggg");
                                }  */
                            }
                        }
                        Cursor res1 = hdb.getalldatapay();
                        if (res1.getCount() == 0) {
                            //seat.status = HallScheme.SeatStatus.FREE;
                            Log.d("dit", "nothinggg");

                        } else {
                            while (res1.moveToNext()) {
                                id122 = res1.getInt(0);
                                status122 = res1.getString(1);
                                if (seat.id == id122 && status122.equalsIgnoreCase("BUSY")) {
                                    // HallScheme.SeatStatus.canSeatBePressed(HallScheme.SeatStatus.BOOKED);
                                    seat.status = HallScheme.SeatStatus.BUSY;
                                    Log.d("dit", "paid done");
                                }
                            }
                        }

                    }
                }
            }
        return seats;
    }


    @Override
    public void onClick(View v) {
        Intent i=new Intent(getActivity(),LoginActivity.class);
        startActivity(i);
    }
}