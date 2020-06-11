package com.mylivingtrip.app.activity.homescreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mylivingtrip.app.MainActivity;
import com.mylivingtrip.app.R;
import com.mylivingtrip.app.activity.homescreen.response.CityResponse;
import com.mylivingtrip.app.activity.homescreen.adapter.ContactsAdapter;
import com.mylivingtrip.app.databinding.ActivityCityNameListBinding;
import com.mylivingtrip.app.retrofit.ApiClient;
import com.mylivingtrip.app.retrofit.ApiInterface;
import com.mylivingtrip.app.utils.InternetConnection;

import retrofit2.Call;
import retrofit2.Callback;

public class CityListActivity extends AppCompatActivity implements ContactsAdapter.ContactsAdapterListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ContactsAdapter mAdapter;
    private ActivityCityNameListBinding activityDashboardBinding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = DataBindingUtil.setContentView(this, R.layout.activity_city_name_list);


        if(InternetConnection.checkConnection(getApplicationContext()))
        {
            getCityName();
        }
        else
        {
            Toast.makeText(this, "Please check internet connection", Toast.LENGTH_SHORT).show();
            
        }

        activityDashboardBinding.imgBackArror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        

    }


    private void getCityName() {

        activityDashboardBinding.progressBar.setVisibility(View.VISIBLE);
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<CityResponse> call = apiService.getCityList();

        call.enqueue(new Callback<CityResponse>() {
            @Override
            public void onResponse(Call<CityResponse> call, retrofit2.Response<CityResponse> response) {

                activityDashboardBinding.progressBar.setVisibility(View.GONE);

                Log.e("Success", new Gson().toJson(response.body()));
                Log.e("Respnse", response.code() + "");

                if (response.body() != null) {


                    mAdapter = new ContactsAdapter(CityListActivity.this, response.body().getFlightcity(),CityListActivity.this);


                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    activityDashboardBinding. rrCityList.setLayoutManager(mLayoutManager);
                    activityDashboardBinding.rrCityList.setItemAnimator(new DefaultItemAnimator());
                    activityDashboardBinding. rrCityList.addItemDecoration(new MyDividerItemDecoration(CityListActivity.this, DividerItemDecoration.VERTICAL, 36));
                    activityDashboardBinding. rrCityList.setAdapter(mAdapter);

                    activityDashboardBinding. edtsearch.addTextChangedListener(new TextWatcher() {

                        @Override
                        public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                            mAdapter.getFilter().filter(cs);
                        }

                        @Override
                        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                           
                        }

                        @Override
                        public void afterTextChanged(Editable arg0) {
                           
                        }
                    });
                }

            }

            @Override
            public void onFailure(Call<CityResponse> call, Throwable t) {
                activityDashboardBinding.progressBar.setVisibility(View.GONE);
                  Toast.makeText(CityListActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                  
            }
        });

    }

    @Override
    public void onContactSelected(CityResponse.FlightcityBean flightcityBean) {

        Intent intent_type=getIntent();
        String type = intent_type.getStringExtra("type");
        Intent intent = new Intent("filter_string");
        intent.putExtra("cityname", flightcityBean.getAirportCity());
        intent.putExtra("airportname", flightcityBean.getAirportName());
        intent.putExtra("airpostcode",  flightcityBean.getAirportCode());
        intent.putExtra("type", type);
        // put your all data using put extra

        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        finish();
    }



}
