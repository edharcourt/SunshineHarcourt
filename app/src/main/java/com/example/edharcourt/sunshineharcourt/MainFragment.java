package com.example.edharcourt.sunshineharcourt;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * http://api.openweathermap.org/data/2.5/forecast/daily?q=13625,us&cnt=7&APPID=ad7b5e8f17dd3930033d94f852efacee
 *
 * Boiler plate for URL connection
 * 
 * https://gist.github.com/udacityandroid/d6a7bb21904046a91695
 *
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    ArrayAdapter<String> mForecastAdapter = null;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_main, container, false);

        String [] data = new String []{"Mon, Sunny", "Tue, Cloudy", "Wed, Rainy",
                "Thu, Partly Sunny", "Fri, Snow", "Sat, Sleet", "Sun, Fog"};

        List<String> forcast = Arrays.asList(data);

        mForecastAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list_item_foracst,
                R.id.list_item_forcast_textview,
                forcast);

        ListView lv = (ListView) root.findViewById(R.id.listview_forcast);
        lv.setAdapter(mForecastAdapter);

        return root;
    }

}
