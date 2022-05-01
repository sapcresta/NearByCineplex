package com.example.sapana.nearbycineplex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sapana.nearbycineplex.sql.DatabaseHelper1;

public class Main4Activity extends AppCompatActivity {

    Button submit,show;
    DatabaseHelper1 databaseHelper;

    EditText etname,etnumber;
    String name,country ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        etname = (EditText) findViewById(R.id.etname);
        etnumber = (EditText) findViewById(R.id.etphone);
        submit = (Button) findViewById(R.id.submit);


        show= (Button) findViewById(R.id.show);

       databaseHelper = new DatabaseHelper1(this);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etname.getText().toString();
                country = etnumber.getText().toString();
                //Toast.makeText(MainActivity.this,name, Toast.LENGTH_SHORT).show();
                if (name.isEmpty() && country.isEmpty()){

                    Toast.makeText(Main4Activity.this, "please fill details", Toast.LENGTH_SHORT).show();
                }else {

                    databaseHelper.insertdata(name,country);
                    etname.setText("");
                    etnumber.setText("");
                    Intent intent = new Intent(Main4Activity.this,Viewall.class);
                    startActivity(intent);

                }




            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main4Activity.this,Viewall.class);
                startActivity(intent);
            }
        });



    }
}
