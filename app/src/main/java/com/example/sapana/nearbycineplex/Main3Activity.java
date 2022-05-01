package com.example.sapana.nearbycineplex;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;
import android.support.v7.widget.CardView;

import com.example.sapana.nearbycineplex.sql.halldatabase;


public class Main3Activity extends AppCompatActivity implements Communicator {

    GridLayout mainGrid;
    halldatabase hdb10=new halldatabase(this);
    public static int priceFood00=0;
    public static int priceFood01=0;
    public static int priceFood02=0;
    public static int priceFood10=0;
    public static int priceFood11=0;
    public static int priceFood12=0;
    public static int priceFood20=0;
    public static int priceFood21=0;
    public static int priceFood22=0;
    public static int priceFood3=0;
    public static int priceFood40=0;
    public static int priceFood41=0;
    public static int priceFood42=0;
    public static int priceFood5=0;
    public static int priceFood6=0;
    public static int totalFoodPrice=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        //Set Event
        //setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(Main3Activity.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(Main3Activity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

 /*   private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(Main3Activity.this,foodorder.class);
                    intent.putExtra("info","This is activity from card item index  "+finalI);
                    startActivity(intent);

                }
            });
        }
    } */

    public void showAlertDialog(View v)
    {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("Normal Popcorn");
        alertDialog.setMessage("Select any size from below:");
        alertDialog.setPositiveButton("large", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Rs.200 has been added.",Toast.LENGTH_SHORT).show();
                priceFood02=200;
            }
        });
        alertDialog.setNeutralButton("small", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Rs.90 has been added.",Toast.LENGTH_SHORT).show();
                priceFood00=90;
            }
        });
        alertDialog.setNegativeButton("medium", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Rs.150 has been added.",Toast.LENGTH_SHORT).show();
                priceFood01=150;
            }
        });
        alertDialog.show();
    }

    public void showAlertDialog1(View v)
    {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("Cheese Popcorn");
        alertDialog.setMessage("Select any size from below:");
        alertDialog.setPositiveButton("large", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Rs.230 has been added.",Toast.LENGTH_SHORT).show();
                priceFood12=230;
            }
        });
        alertDialog.setNeutralButton("small", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Rs.110 has been added.",Toast.LENGTH_SHORT).show();
                priceFood10=110;
            }
        });
        alertDialog.setNegativeButton("medium", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Rs.170 has been added.",Toast.LENGTH_SHORT).show();
                priceFood11=170;
            }
        });
        alertDialog.show();
    }

    public void showAlertDialog2(View v)
    {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("Caramel Popcorn");
        alertDialog.setMessage("Select any size from below:");
        alertDialog.setPositiveButton("large", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Rs.280 has been added.",Toast.LENGTH_SHORT).show();
                priceFood22=280;
            }
        });
        alertDialog.setNeutralButton("small", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Rs.130 has been added.",Toast.LENGTH_SHORT).show();
                priceFood20=130;
            }
        });
        alertDialog.setNegativeButton("medium", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Rs.190 has been added.",Toast.LENGTH_SHORT).show();
                priceFood21=190;
            }
        });
        alertDialog.show();
    }

    public void showAlertDialog3(View v)
    {
        Toast.makeText(getApplicationContext(),"Rs.270 has been added.",Toast.LENGTH_SHORT).show();
        priceFood3=270;
    }

    public void showAlertDialog4(View v)
    {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("Coke/Fanta/Sprite");
        alertDialog.setMessage("Select any drink from below:");
        alertDialog.setPositiveButton("sprite", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Rs.110 has been added.",Toast.LENGTH_SHORT).show();
                priceFood42=110;
            }
        });
        alertDialog.setNeutralButton("coke", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Rs.110 has been added.",Toast.LENGTH_SHORT).show();
                priceFood40=110;
            }
        });
        alertDialog.setNegativeButton("fanta", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Rs.110 has been added.",Toast.LENGTH_SHORT).show();
                priceFood41=110;
            }
        });
        alertDialog.show();
    }

    public void showAlertDialog5(View v)
    {
        Toast.makeText(getApplicationContext(),"Rs.210 has been added.",Toast.LENGTH_SHORT).show();
        priceFood5=210;
    }

    public void showAlertDialog6(View v)
    {
        Toast.makeText(getApplicationContext(),"Rs.230 has been added.",Toast.LENGTH_SHORT).show();
        priceFood6=230;
    }

    public static int totalfoodPrice(){
        totalFoodPrice=priceFood00+priceFood01+priceFood02+priceFood10+priceFood11+priceFood12+priceFood20+priceFood21+priceFood22+priceFood3+priceFood40+priceFood41+priceFood42+priceFood5+priceFood6;
        return totalFoodPrice;
    }

    public void nextbook(View view) {
        Intent i=new Intent(this,booknow.class);
        startActivity(i);
    }

        @Override
        public void respond(int seat_data) {
            hdb10.insertdatapay(seat_data,"BUSY");
            Log.d("dit","data insertion to pay");
        }


}
