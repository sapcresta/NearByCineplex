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
public class FragmentWhen extends Fragment implements View.OnClickListener {
    Button a,b,c,d,e,f,g,h,i,j,k;


    public FragmentWhen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_when, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        a=(Button)getActivity().findViewById(R.id.a);
        b=(Button)getActivity().findViewById(R.id.b);
        c=(Button)getActivity().findViewById(R.id.c);
        d=(Button)getActivity().findViewById(R.id.d);
        e=(Button)getActivity().findViewById(R.id.e);
        f=(Button)getActivity().findViewById(R.id.f);
        g=(Button)getActivity().findViewById(R.id.g);
        h=(Button)getActivity().findViewById(R.id.h);
        i=(Button)getActivity().findViewById(R.id.i);
        j=(Button)getActivity().findViewById(R.id.j);
        k=(Button)getActivity().findViewById(R.id.k);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        g.setOnClickListener(this);
        a.setOnClickListener(this);
        a.setOnClickListener(this);
        a.setOnClickListener(this);
        a.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

                    Intent i5 = new Intent(getActivity(), Main2Activity.class);
                    startActivity(i5);

            }

}
