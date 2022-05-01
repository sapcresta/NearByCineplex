package com.example.sapana.nearbycineplex;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.sapana.nearbycineplex.Config.paynow;
import com.example.sapana.nearbycineplex.sql.halldatabase;

public class booknow extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    TextView price;
    TextView foodprice;
    TextView finalprice;
    TextView totalSeats;
    private int totalfood;
    public int ticketPrice;
    public  int finalPrice;
    halldatabase hdb;
    String finallSum;
    int finalsum;
    Main3Activity m3=new Main3Activity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booknow);
        price=(TextView) findViewById(R.id.totalprice);
        foodprice=(TextView) findViewById(R.id.foodpriceid);
        finalprice=(TextView)findViewById(R.id.finalpriceid);
        totalSeats=(TextView)findViewById(R.id.noofseats);
        getfoodvalue();
        getCounterValue();
        getSeatCount();
        getTotalValue();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        hdb=new halldatabase(this);


    }
    private void getSeatCount() {
        int seats=finalPrice;
        Integer r3=seats;
        String finalseats=r3.toString();
        //android.widget.Toast.makeText(this,"successfully data was found",android.widget.Toast.LENGTH_SHORT).show();
        totalSeats.setText(finalseats);
    }

    private void getTotalValue() {
         finalsum=totalfood+ticketPrice;
        Integer r2=finalsum;
         finallSum=r2.toString();
        //android.widget.Toast.makeText(this,"successfully data was found",android.widget.Toast.LENGTH_SHORT).show();
        finalprice.setText(finallSum);
    }

    private void getfoodvalue() {
        totalfood=m3.totalfoodPrice();
        Integer r1=totalfood;
        String finalFood=r1.toString();
        //android.widget.Toast.makeText(this,"successfully data was found",android.widget.Toast.LENGTH_SHORT).show();
        foodprice.setText(finalFood);

    }

    public void getCounterValue() {
        android.content.SharedPreferences sharedPreferences=getSharedPreferences("mydata", android.content.Context.MODE_PRIVATE);
        String ticketprice=sharedPreferences.getString("counterValue","n/a");
        finalPrice=Integer.parseInt(ticketprice);
        android.widget.Toast.makeText(this,"successfully data was found"+ticketprice,android.widget.Toast.LENGTH_SHORT).show();
        if(ticketprice.equals("n/a")){

            android.widget.Toast.makeText(this,"no data was found",android.widget.Toast.LENGTH_SHORT).show();}

        else{
            ticketPrice=250*finalPrice;
            Integer r=ticketPrice;
            String finalCal=r.toString();
            android.widget.Toast.makeText(this,"successfully data was found",android.widget.Toast.LENGTH_SHORT).show();
            price.setText(finalCal);
        }

    }
    public void pay(View view) {
        Intent i = new Intent(this, paynow.class);
        i.putExtra("payvalue",finallSum);
        startActivity(i);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.navigation_home:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.login:
                Intent jl = new Intent(this, LoginActivity.class);
                startActivity(jl);
                break;
            case R.id.register:
                Intent j = new Intent(this, newregister.class);
                startActivity(j);
                break;
            case R.id.feedback:
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                String[] to={"sapshrestha4@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, to);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback From Nearby Cineplex App");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                intent.setType("message/rfc822");
                Intent chooser=Intent.createChooser(intent,"Send Email");
                startActivity(chooser);
                // Toast.makeText(this, "FeedBack was click", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }

    public void viewseats(View view) {

        Cursor res=hdb.getalldata();
        if(res.getCount()==0){
            showmessage("error","nothing found");
        }
        StringBuffer buffer=new StringBuffer();
        while(res.moveToNext()){
            buffer.append("ID: "+res.getInt(0)+"\n");
            buffer.append("STATUS: "+res.getString(1)+"\n");
            Log.d("dit","color changed");
        }
        showmessage("your seats are",buffer.toString());
    }

    public void viewseats2(View view) {

        Cursor res=hdb.getalldata1();
        if(res.getCount()==0){
            showmessage("error","nothing found");
        }
        StringBuffer buffer=new StringBuffer();
        while(res.moveToNext()){
            buffer.append("ID: "+res.getInt(0)+"\n");
            buffer.append("STATUS: "+res.getString(1)+"\n");
        }
        showmessage("your seats are",buffer.toString());
    }

    public void viewseats3(View view) {

        Cursor res=hdb.getalldata2();
        if(res.getCount()==0){
            showmessage("error","nothing found");
        }
        StringBuffer buffer=new StringBuffer();
        while(res.moveToNext()){
            buffer.append("ID: "+res.getInt(0)+"\n");
            buffer.append("STATUS: "+res.getString(1)+"\n");
        }
        showmessage("your seats are",buffer.toString());
    }

    public void viewseats4(View view) {

        Cursor res=hdb.getalldata3();
        if(res.getCount()==0){
            showmessage("error","nothing found");
        }
        StringBuffer buffer=new StringBuffer();
        while(res.moveToNext()){
            buffer.append("ID: "+res.getInt(0)+"\n");
            buffer.append("STATUS: "+res.getString(1)+"\n");
        }
        showmessage("your seats are",buffer.toString());
    }

 /*   public Seat[][] change() {
        Seat seats[][] = new Seat[15][15];
        for (int i=0; i<15; i++) //rows
            for(int j =0; j<15; j++) {
                SeatExample seat = new SeatExample();
                seat.selectedSeatMarker = String.valueOf(j+1);
                seat.status = HallScheme.SeatStatus.EMPTY;
                seats[i][j] = seat;
                if (i >= 0 && i < 15) { //bujhyo  1st four row free
                    seat.status = HallScheme.SeatStatus.BOOKED;
                }
            }
        return seats;
    } */


    public void showmessage(String title,String message){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
