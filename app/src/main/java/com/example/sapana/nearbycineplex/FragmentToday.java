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
public class FragmentToday extends Fragment implements View.OnClickListener {
    Button ctcbtn,ctcbtn1,qfxbtn,labimbtn,bgbtn,bgbtn1;


    public FragmentToday() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_today, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ctcbtn=(Button) getActivity().findViewById(R.id.CTCbtn);
        ctcbtn1=(Button) getActivity().findViewById(R.id.CTCbtn1);
        qfxbtn=(Button)getActivity().findViewById(R.id.qfxbtn);
        labimbtn=(Button) getActivity().findViewById(R.id.labimbtn);
        bgbtn=(Button)getActivity().findViewById(R.id.bgbtn);
        bgbtn1=(Button)getActivity().findViewById(R.id.bgbtn1);


        ctcbtn.setOnClickListener(this);
        ctcbtn1.setOnClickListener(this);
       qfxbtn.setOnClickListener(this);
       labimbtn.setOnClickListener(this);
       bgbtn.setOnClickListener(this);
      bgbtn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.CTCbtn:
            Intent i = new Intent(getActivity(), Main2Activity.class);
            startActivity(i);
            break;
            case R.id.CTCbtn1:
                Intent i2 = new Intent(getActivity(),hallList2.class);
                startActivity(i2);
                break;
            case R.id.qfxbtn:
                Intent i3 = new Intent(getActivity(), hallList1.class);
                startActivity(i3);
                break;
            case R.id.labimbtn:
                Intent i4 = new Intent(getActivity(), hallList3.class);
                startActivity(i4);
                break;
            case R.id.bgbtn:
                Intent i5 = new Intent(getActivity(), hallList4.class);
                startActivity(i5);
                break;
            case R.id.bgbtn1:
                Intent i6 = new Intent(getActivity(), hallList4.class);
                startActivity(i6);
                break;
        }
    }
}
