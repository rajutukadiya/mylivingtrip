package com.mylivingtrip.app.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.mylivingtrip.app.R;
import com.mylivingtrip.app.activity.flightlist.ListingOfFlightActivity;
import com.mylivingtrip.app.activity.flightlist.ListingOfFlightActivity_;
import com.mylivingtrip.app.activity.homescreen.CityNameListActivity;
import com.mylivingtrip.app.activity.travellersandclass.TravellersandClassActivity;
import com.mylivingtrip.app.databinding.FragmentSearchFlightBinding;

import java.util.Calendar;

import static android.app.Activity.RESULT_OK;


public class SearchFlightFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int request_Code=111;

    private String mParam1;
    private String mParam2;
    private FragmentSearchFlightBinding fragmentSearchFlightBinding;

    public SearchFlightFragment() {

    }


    public static SearchFlightFragment newInstance(String param1, String param2) {
        SearchFlightFragment fragment = new SearchFlightFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentSearchFlightBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_flight, container, false);

        View rootView = fragmentSearchFlightBinding.getRoot();

        initialization();

        listener();

        return rootView;

    }

    private void listener() {

        fragmentSearchFlightBinding.rlOneWay.setOnClickListener(this);
        fragmentSearchFlightBinding.rlRoundTrip.setOnClickListener(this);
        fragmentSearchFlightBinding.txttodateretim.setOnClickListener(this);
        fragmentSearchFlightBinding.txttodate.setOnClickListener(this);
        fragmentSearchFlightBinding.rlSearch.setOnClickListener(this);
        fragmentSearchFlightBinding.rrFrom.setOnClickListener(this);
        fragmentSearchFlightBinding.rrTo.setOnClickListener(this);
        fragmentSearchFlightBinding. llTravellersandcabinclass.setOnClickListener(this);

    }

    private void initialization() {

        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(getActivity());
        lbm.registerReceiver(receiver, new IntentFilter("filter_string"));
    }


    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String str = intent.getStringExtra("type");
                String cityname = intent.getStringExtra("cityname");
                String airportname = intent.getStringExtra("airportname");
                String airpostcode = intent.getStringExtra("airpostcode");
                String type = intent.getStringExtra("type");
                if(type.equalsIgnoreCase("to"))
                {

                    fragmentSearchFlightBinding.txttocity.setText(cityname);
                    fragmentSearchFlightBinding.txtToCitySortName.setText(airpostcode);
                    fragmentSearchFlightBinding.txttoaddress.setText(airportname);

                }
                else
                {
                    fragmentSearchFlightBinding.txtcity.setText(cityname);
                    fragmentSearchFlightBinding.txtCitySortName.setText(airpostcode);
                    fragmentSearchFlightBinding.txtaddress.setText(airportname);
                }
            }
        }
    };
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == request_Code) {
            if (resultCode == RESULT_OK) {

            }
        }
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llTravellersandcabinclass:
                Intent intentTravelandcabinclass=new Intent(getActivity(), TravellersandClassActivity.class);
                getActivity(). startActivity(intentTravelandcabinclass);
                break;
            case R.id.rrTo:
                Intent intentListCityto=new Intent(getActivity(), CityNameListActivity.class);
                intentListCityto.putExtra("type","to");
               getActivity(). startActivity(intentListCityto);
                break;
            case R.id.rrFrom:
                Intent intentListCityfrom=new Intent(getActivity(), CityNameListActivity.class);
                intentListCityfrom.putExtra("type","from");
                startActivity(intentListCityfrom);
                break;
            case R.id.rlSearch:
                Intent intent=new Intent(getActivity(), ListingOfFlightActivity_.class);
                String ToSortName= fragmentSearchFlightBinding.txtToCitySortName.getText().toString();
                String FormSortName= fragmentSearchFlightBinding.txtCitySortName.getText().toString();
                intent.putExtra("to",ToSortName);
                intent.putExtra("from",FormSortName);
                startActivity(intent);
                break;

            case R.id.rlOneWay:
                fragmentSearchFlightBinding.rlOneWay.setBackgroundResource(R.drawable.roundbutton);
                fragmentSearchFlightBinding.rlRoundTrip.setBackgroundResource(0);
                fragmentSearchFlightBinding.txtOnwWay.setTextColor(getResources().getColor(R.color.white));
                fragmentSearchFlightBinding.txtrountrip.setTextColor(getResources().getColor(R.color.black));
                fragmentSearchFlightBinding.txttodatedegitretun.setVisibility(View.GONE);
                fragmentSearchFlightBinding.txttodateretim.setVisibility(View.GONE);
                fragmentSearchFlightBinding.txtonewaytrip.setVisibility(View.VISIBLE);
                break;
            case R.id.rlRoundTrip:
                fragmentSearchFlightBinding.txtonewaytrip.setVisibility(View.GONE);
                fragmentSearchFlightBinding.rlOneWay.setBackgroundResource(0);
                fragmentSearchFlightBinding.rlRoundTrip.setBackgroundResource(R.drawable.roundbutton);
                fragmentSearchFlightBinding.txtOnwWay.setTextColor(getResources().getColor(R.color.black));
                fragmentSearchFlightBinding.txtrountrip.setTextColor(getResources().getColor(R.color.white));
                fragmentSearchFlightBinding.txttodatedegitretun.setVisibility(View.VISIBLE);
                fragmentSearchFlightBinding.txttodateretim.setVisibility(View.VISIBLE);
                break;

            case R.id.txttodate:
                DialogFragment newFragmentto= new DatePickerFragment();
                newFragmentto.show(getFragmentManager(), "datePicker");
                break;
            case R.id.txttodateretim:
                DialogFragment newFragmentFrom = new DatePickerFragment();
                newFragmentFrom.show(getFragmentManager(), "datePicker");
                break;
        }
    }

        public static class DatePickerFragment extends DialogFragment
                implements DatePickerDialog.OnDateSetListener {

            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);
                dialog.getDatePicker().setMinDate(c.getTimeInMillis());
                return  dialog;
            }

            public void onDateSet(DatePicker view, int year, int month, int day) {
               // btnDate.setText(ConverterDate.ConvertDate(year, month + 1, day));
            }
        }

}
