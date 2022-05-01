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
import android.support.v7.app.AppCompatActivity;

import com.example.sapana.nearbycineplex.R;
import com.example.sapana.nearbycineplex.SeatExample;
import com.example.sapana.nearbycineplex.hall.HallScheme;
import com.example.sapana.nearbycineplex.hall.ScenePosition;
import com.example.sapana.nearbycineplex.hall.Seat;
import com.example.sapana.nearbycineplex.hall.SeatListener;
import com.example.sapana.nearbycineplex.sql.halldatabase;
import com.example.sapana.nearbycineplex.view.ZoomableImageView;

/**
 * Created by Nublo on 05.12.2015.
 * Copyright Nublo
 */
public class SchemeWithScene extends Fragment implements View.OnClickListener{
    Button nextfood3;
    Communicator comm;
    //Communicator2 comm2;
    halldatabase h11;
    public static int id31;
    public static String status31;
    public  static int counter=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h11=new halldatabase(getActivity());
        View rootView = inflater.inflate(R.layout.basic_scheme_fragment, container, false);
        ZoomableImageView imageView = (ZoomableImageView) rootView.findViewById(R.id.zoomable_image);
        HallScheme scheme = new HallScheme(imageView, schemeWithScene(), getActivity()); //object
        scheme.setScenePosition(ScenePosition.SOUTH); //screen ko position
        scheme.setSeatListener(new SeatListener() {

            @Override
            public void selectSeat(int id) { //HallScheme.SeatStatus status
                comm.respond(id);
                counter++;
                Toast.makeText(getActivity(), " select seat "+ id +" total seat:"+counter, Toast.LENGTH_SHORT).show();
                saveCounter(counter);}

            @Override
            public void unSelectSeat(int id) {
                counter--;
                Toast.makeText(getActivity(), " Unselect seat "+ id +" total seat:"+counter, Toast.LENGTH_SHORT).show();
                saveCounter(counter);}

        });
        return rootView;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        nextfood3=(Button)getActivity().findViewById(R.id.nextfood);
        nextfood3.setOnClickListener(this);
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

    public Seat[][] schemeWithScene() {
        Seat seats[][] = new Seat[16][29];
        int k = 0;
        for (int i = 0; i < 16; i++) //row
            for(int j = 0; j < 29; j++) { //column
                SeatExample seat = new SeatExample();
                seat.id = ++k;
                seat.selectedSeatMarker = String.valueOf(j+1);
                seat.status = HallScheme.SeatStatus.EMPTY; //seat nai chaina
                seats[i][j] = seat;
                if (i < 5 && j < 4) { //bujhyo  1st four row free
                    seat.status = HallScheme.SeatStatus.BUSY;
                    if (i < 4) {
                        seat.status = HallScheme.SeatStatus.FREE;
                        seat.color = Color.argb(255, 60, 179, 113); //changes

                        Cursor res = h11.getalldata3();
                        if (res.getCount() == 0) {
                            //seat.status = HallScheme.SeatStatus.FREE;
                            Log.d("dit", "nothing in schemewithscene2");

                        } else {
                            while (res.moveToNext()) {
                                id31 = res.getInt(0);
                                status31 = res.getString(1);
                                if(seat.id==id31)
                                {
                                    // HallScheme.SeatStatus.canSeatBePressed(HallScheme.SeatStatus.BOOKED);
                                    seat.status=HallScheme.SeatStatus.BOOKED;
                                    Log.d("dit", "hello world"); }

                            }
                        }
                    }
                }
                if (j > 1 && j < 5 && i > 4) { //bujhyo
                    seat.status = HallScheme.SeatStatus.BUSY;
                    if (i > 6) {
                        seat.status = HallScheme.SeatStatus.FREE;
                        seat.color = Color.argb(255, 60, 179, 113);

                        Cursor res = h11.getalldata3();
                        if (res.getCount() == 0) {
                            //seat.status = HallScheme.SeatStatus.FREE;
                            Log.d("dit", "nothing in schemewithscene2");

                        } else {
                            while (res.moveToNext()) {
                                id31 = res.getInt(0);
                                status31 = res.getString(1);
                                if(seat.id==id31)
                                {
                                    // HallScheme.SeatStatus.canSeatBePressed(HallScheme.SeatStatus.BOOKED);
                                    seat.status=HallScheme.SeatStatus.BOOKED;
                                    Log.d("dit", "hello world"); }

                            }
                        }
                    }
                }
                if (j == 4 && i > 1 && i < 5) //top right 4*4 free
                    seat.status = HallScheme.SeatStatus.BUSY;
                if (i < 5 && j > 24) {
                    seat.status = HallScheme.SeatStatus.BUSY;
                    if (i < 4) {
                        seat.status = HallScheme.SeatStatus.FREE;
                        seat.color = Color.argb(255, 60, 179, 113);

                        Cursor res = h11.getalldata3();
                        if (res.getCount() == 0) {
                            //seat.status = HallScheme.SeatStatus.FREE;
                            Log.d("dit", "nothing in schemewithscene2");

                        } else {
                            while (res.moveToNext()) {
                                id31 = res.getInt(0);
                                status31 = res.getString(1);
                                if(seat.id==id31)
                                {
                                    // HallScheme.SeatStatus.canSeatBePressed(HallScheme.SeatStatus.BOOKED);
                                    seat.status=HallScheme.SeatStatus.BOOKED;
                                    Log.d("dit", "hello world"); }

                            }
                        }
                    }
                }
                if (j > 23 && j < 27 && i > 4) {
                    seat.status = HallScheme.SeatStatus.BUSY;
                    if (i > 6) {
                        seat.status = HallScheme.SeatStatus.FREE; //bottom right blue
                        seat.color = Color.argb(255, 60, 179, 113);

                        Cursor res = h11.getalldata3();
                        if (res.getCount() == 0) {
                            //seat.status = HallScheme.SeatStatus.FREE;
                            Log.d("dit", "nothing in schemewithscene2");

                        } else {
                            while (res.moveToNext()) {
                                id31 = res.getInt(0);
                                status31 = res.getString(1);
                                if(seat.id==id31)
                                {
                                    // HallScheme.SeatStatus.canSeatBePressed(HallScheme.SeatStatus.BOOKED);
                                    seat.status=HallScheme.SeatStatus.BOOKED;
                                    Log.d("dit", "hello world"); }

                            }
                        }
                    }
                }
                if (j == 24 && i > 1 && i < 5) //24th column
                    seat.status = HallScheme.SeatStatus.BUSY;
                if (i > 3 && j > 6 && j < 22) {  //bich ko sabai red after 5th row to 13th row
                    seat.status = HallScheme.SeatStatus.BUSY;
                    if (i > 6) {
                        seat.status = HallScheme.SeatStatus.FREE;
                        seat.color = Color.argb(255, 60, 179, 113);

                        Cursor res = h11.getalldata3();
                        if (res.getCount() == 0) {
                            //seat.status = HallScheme.SeatStatus.FREE;
                            Log.d("dit", "nothing in schemewithscene2");

                        } else {
                            while (res.moveToNext()) {
                                id31 = res.getInt(0);
                                status31 = res.getString(1);
                                if(seat.id==id31)
                                {
                                    // HallScheme.SeatStatus.canSeatBePressed(HallScheme.SeatStatus.BOOKED);
                                    seat.status=HallScheme.SeatStatus.BOOKED;
                                    Log.d("dit", "hello world"); }

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