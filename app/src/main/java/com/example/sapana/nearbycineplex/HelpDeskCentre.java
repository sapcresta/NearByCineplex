package com.example.sapana.nearbycineplex;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HelpDeskCentre extends AppCompatActivity implements View.OnClickListener {

    TextView txt0,txt1,txt2,txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_desk_centre);
        txt0 = (TextView) findViewById(R.id.bigmoviescontactno);
        txt1=(TextView) findViewById(R.id.ctccontactno);
        txt2=(TextView)findViewById(R.id.qfxcontactno);
        txt3=(TextView)findViewById(R.id.qfxlabimcontactno) ;
        txt0.setOnClickListener(this);
        txt1.setOnClickListener(this);
        txt2.setOnClickListener(this);
        txt3.setOnClickListener(this);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bigmoviescontactno) {
            Intent callNumber = new Intent(Intent.ACTION_CALL);
            TextView number = (TextView) view.findViewById(R.id.bigmoviescontactno);
            String txt = number.getText().toString();
            callNumber.setData(Uri.parse("tel:" + txt));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(callNumber);
        }

       else if (view.getId() == R.id.ctccontactno) {
            Intent callNumber = new Intent(Intent.ACTION_CALL);
            TextView number = (TextView) view.findViewById(R.id.ctccontactno);
            String txt = number.getText().toString();
            callNumber.setData(Uri.parse("tel:" + txt));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(callNumber);
        }

       else if (view.getId() == R.id.qfxcontactno) {
            Intent callNumber = new Intent(Intent.ACTION_CALL);
            TextView number = (TextView) view.findViewById(R.id.qfxcontactno);
            String txt = number.getText().toString();
            callNumber.setData(Uri.parse("tel:" + txt));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(callNumber);
        }
        else if (view.getId() == R.id.qfxlabimcontactno) {
            Intent callNumber = new Intent(Intent.ACTION_CALL);
            TextView number = (TextView) view.findViewById(R.id.qfxlabimcontactno);
            String txt = number.getText().toString();
            callNumber.setData(Uri.parse("tel:" + txt));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(callNumber);
        }
    }
}
