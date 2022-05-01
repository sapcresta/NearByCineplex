package com.example.sapana.nearbycineplex.Config;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sapana.nearbycineplex.R;

import org.json.JSONException;
import org.json.JSONObject;

public class paymentDetails extends AppCompatActivity {
    TextView txtId, txtAmount, txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);
        txtId= findViewById(R.id.txId);
    txtAmount= findViewById(R.id.txAmount);
    txtStatus= findViewById(R.id.txtStatus);
        Log.d("dit","paymentdetails oncreate called");

    Intent intent= getIntent();
    try{
        JSONObject jsonObject= new JSONObject(intent.getStringExtra("paymentDetails22"));
        showDetails(jsonObject.getJSONObject("response"),intent.getStringExtra("paymentAmount11"));


    }catch(JSONException e){
        e.printStackTrace();
    }

    }

    private void showDetails(JSONObject response, String paymentAmount) {
        try {
            txtId.setText(response.getString("id"));
            txtAmount.setText("Rs"+paymentAmount);
            txtStatus.setText(response.getString("state"));
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }


}
