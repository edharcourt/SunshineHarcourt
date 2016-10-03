package com.example.edharcourt.sunshineharcourt;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
public class ForecastFragment extends Fragment implements OnWeatherTaskCompleted {

    ArrayAdapter<String> mForecastAdapter = null;

    private final static String LOG_TAG = ForecastFragment.class.getSimpleName();

    public ForecastFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.forecastfragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            String APIKEY = "ad7b5e8f17dd3930033d94f852efacee";

            Uri.Builder builder = new Uri.Builder();
            builder.scheme("http").
                    authority("api.openweathermap.org").
                    appendPath("data").
                    appendPath("2.5").
                    appendPath("forecast").
                    appendPath("daily").
                    appendQueryParameter("q", "13625,us").
                    appendQueryParameter("cnt", "7").
                    appendQueryParameter("APPID", APIKEY);

            String url = builder.build().toString();
            Log.v(LOG_TAG, url);

            GetWeatherForecastTask getWeatherForecastTask = new GetWeatherForecastTask(this);
            getWeatherForecastTask.execute(url);
            return true;
        }
        return super.onOptionsItemSelected(item);
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

    @Override
    public void onTaskCmpleted(String result) {
        String tmp = result;
        return;

    }



}
