package com.example.sapana.nearbycineplex.Config;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sapana.nearbycineplex.Config.Config;
import com.example.sapana.nearbycineplex.Config.paymentDetails;
import com.example.sapana.nearbycineplex.LoginActivity;
import com.example.sapana.nearbycineplex.MainActivity;
import com.example.sapana.nearbycineplex.R;
import com.example.sapana.nearbycineplex.booknow;
import com.example.sapana.nearbycineplex.hall.HallScheme;
import com.example.sapana.nearbycineplex.newregister;
import com.example.sapana.nearbycineplex.sql.halldatabase;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;

import static android.app.ProgressDialog.show;
import static com.paypal.android.sdk.cu.s;

public class paynow extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    public static final int PAYPAL_REQUEST_CODE=7171;
    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(Config.PAYPAL_CLIENT_ID);

    halldatabase hdb1;
    String s;
    Button btnPaynow;
    TextView edtAmount;
    String amount="";
    booknow bn;

    @Override
    protected void onDestroy() {
        stopService(new Intent(this,PayPalService.class));
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paynow);

       s=getIntent().getStringExtra("payvalue");

        //start paypal service
        Intent intent = new Intent(this,PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        startService(intent);

        hdb1=new halldatabase(this);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Toast.makeText(this,"amt="+s,Toast.LENGTH_LONG).show();
        btnPaynow=(Button)findViewById(R.id.paylogin);
        edtAmount=(TextView) findViewById(R.id.edtAmount);
        edtAmount.setText(s);
        btnPaynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                processPayment();
            }
        });

    }

    private void processPayment() {

        amount=s;
        PayPalPayment payPalPayment= new PayPalPayment(new BigDecimal(String.valueOf(amount)),"USD",
                "Pay for Movies and Food Items",PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent= new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);
        startActivityForResult(intent,PAYPAL_REQUEST_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PAYPAL_REQUEST_CODE) {

            if (resultCode == RESULT_OK) {
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirmation != null)
                    try {
                        String payementDetails = confirmation.toJSONObject().toString(4);
                        startActivity(new Intent(this, paymentDetails.class)
                                .putExtra("paymentDetails22", payementDetails)

                                .putExtra("paymentAmount11", amount)

                        );
                        Log.d("pal","value successfully passed");


                    } catch (JSONException e) {
                    Log.d("dit","exception called");
                        e.printStackTrace();
                    }
            }

         else if(resultCode== Activity.RESULT_CANCELED)
            Toast.makeText(this,"Cancel", Toast.LENGTH_SHORT).show();
    }
    else if(resultCode== PaymentActivity.RESULT_EXTRAS_INVALID)
    Toast.makeText(this,"Invalid", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onBackPressed() {
       // navigateUpTo(new Intent(getBaseContext(), MainActivity.class))
        super.onBackPressed(); // this can go before or after your stuff below
        // do your stuff when the back button is pressed
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        // super.onBackPressed(); calls finish(); for you

        // clear your SharedPreferences
        getSharedPreferences("mydata",0).edit().clear().commit();

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





}
