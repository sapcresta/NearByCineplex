package com.example.sapana.nearbycineplex;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class
FragmentTomorrow extends Fragment implements View.OnClickListener {
    Button one,two,three,four,five,six;

    public FragmentTomorrow() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tomorrow, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        one=(Button) getActivity().findViewById(R.id.one);
        two=(Button) getActivity().findViewById(R.id.two);
        three=(Button) getActivity().findViewById(R.id.three);
        four=(Button) getActivity().findViewById(R.id.four);
       five=(Button) getActivity().findViewById(R.id.five);
        six=(Button) getActivity().findViewById(R.id.six);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
       five.setOnClickListener(this);
       six.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.one:
                Intent i = new Intent(getActivity(), hallList2.class);
                startActivity(i);
                break;
            case R.id.two:
                Intent i1 = new Intent(getActivity(), Main2Activity.class);
                startActivity(i1);
                break;
            case R.id.three:
                Intent i2 = new Intent(getActivity(), hallList1.class);
                startActivity(i2);
                break;
            case R.id.four:
                Intent i3 = new Intent(getActivity(), hallList1.class);
                startActivity(i3);
                break;
            case R.id.five:
                Intent i4 = new Intent(getActivity(), hallList3.class);
                startActivity(i4);
                break;
                case R.id.six:
                Intent i5 = new Intent(getActivity(), hallList4.class);
                startActivity(i5);
                break;
        }
    }

}
