package com.example.sapana.nearbycineplex;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sapana.nearbycineplex.hall.HallScheme;
import com.example.sapana.nearbycineplex.sql.halldatabase;

public class hallList2 extends AppCompatActivity implements Communicator{
    halldatabase hdb;
    public static String status2;
    public static int id2;
    //SchemeBasic obj=new SchemeBasic();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_list2);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new ListFragment()).commit();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Log.d("dit","hallList2 oncreate called");
        hdb=new halldatabase(this);
    }

    @Override
    public void respond(int seat_data) {  //,String seat_status
        hdb.insertdata1(seat_data,"BOOKED");
        Log.d("dit","data 2 insertion successful");

    }


    public static class ListFragment extends Fragment {

        private static final String[] halls = {"CTC Audio 2"};

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.halls_fragment, container, false);
            ListView hallListView = (ListView) rootView.findViewById(R.id.hall_examples);
            ArrayAdapter<String> listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, halls);
            hallListView.setAdapter(listAdapter);

            hallListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0 :
                            replaceFragmentAndAddToBackStack(new SchemeBasic2());
                            break;
                    }
                }
            });
            return rootView;
        }

        public void replaceFragmentAndAddToBackStack(Fragment fragment) {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment, fragment)
                    .addToBackStack(null)
                    .commit();
        }

    }

}

