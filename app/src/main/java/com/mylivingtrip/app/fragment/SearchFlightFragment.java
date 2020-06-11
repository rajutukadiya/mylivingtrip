package com.mylivingtrip.app.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
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
import com.mylivingtrip.app.activity.flightlist.ListingOfFlightActivity_;
import com.mylivingtrip.app.activity.homescreen.CityListActivity;
import com.mylivingtrip.app.activity.travellersandclass.TravellersandClassActivity;
import com.mylivingtrip.app.databinding.FragmentSearchFlightBinding;
import com.mylivingtrip.app.utils.Pref;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;


public class SearchFlightFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int request_Code = 111;
    private String mParam1;
    private String mParam2;
    private FragmentSearchFlightBinding fragmentSearchFlightBinding;
    private String todate = "", returndata = "", todatewithmotnname = "", returndatamothname = "";
    private Pref pref;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String str = intent.getStringExtra("type");
                String cityname = intent.getStringExtra("cityname");
                String airportname = intent.getStringExtra("airportname");
                String airpostcode = intent.getStringExtra("airpostcode");
                String type = intent.getStringExtra("type");
                if (type.equalsIgnoreCase("to")) {

                    fragmentSearchFlightBinding.txttocity.setText(cityname);
                    fragmentSearchFlightBinding.txtToCitySortName.setText(airpostcode);
                    fragmentSearchFlightBinding.txttoaddress.setText(airportname);

                } else {
                    fragmentSearchFlightBinding.txtcity.setText(cityname);
                    fragmentSearchFlightBinding.txtCitySortName.setText(airpostcode);
                    fragmentSearchFlightBinding.txtaddress.setText(airportname);
                }
            }
        }
    };
    private BroadcastReceiver receiver_datatime = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {

                String monthName = intent.getStringExtra("monthName");
                String year = intent.getStringExtra("year");
                String dayOfWeek = intent.getStringExtra("dayOfWeek");
                String type = intent.getStringExtra("type");
                String day = intent.getStringExtra("day");
                String month = intent.getStringExtra("month");

                if (type.equalsIgnoreCase("todate")) {

                    todate = year + "-" + month + "-" + day;
                    todatewithmotnname = day + " " + monthName;
                    fragmentSearchFlightBinding.txttodate.setText(monthName + " " + year + " \n" + dayOfWeek);
                    fragmentSearchFlightBinding.txttodatedegit.setText(day);

                } else {
                    returndata = year + "-" + month + "-" + day;
                    returndatamothname = day + " " + monthName;
                    fragmentSearchFlightBinding.txttodateretim.setText(monthName + " " + year + " \n" + dayOfWeek);
                    fragmentSearchFlightBinding.txttodatedegitretun.setText(day);
                }
            }
        }
    };

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

        setDefalutDate();

        return rootView;

    }


    @SuppressLint("SetTextI18n")
    private void setDefalutDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        String date = day + "-" + month + "-" + year;
        Log.e("date", date);
        String dayOfWeek = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            DateTimeFormatter dayOfWeekFormatter
                    = DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH);
            LocalDate datee = LocalDate.of(
                    year, month + 1, day);
            dayOfWeek = datee.format(dayOfWeekFormatter);
        }
        int month_ = month + 1;
        todate =year  + "-" + month_ + "-" + day;

        todatewithmotnname = day + " " + getNameOfMonth(month_);
        fragmentSearchFlightBinding.txttodate.setText(getNameOfMonth(month_) + " " + year + " \n" + dayOfWeek);
        fragmentSearchFlightBinding.txttodatedegit.setText(day + "");

    }

    private void roundTripDetultdate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 2);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        String date = day + "-" + month + "-" + year;
        Log.e("date", date);
        String dayOfWeek = "";

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            DateTimeFormatter dayOfWeekFormatter
                    = DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH);
            LocalDate datee = LocalDate.of(
                    year, month + 1, day);
            dayOfWeek = datee.format(dayOfWeekFormatter);
        }

        int month_ = month + 1;
        returndata = year + "-" + month_ + "-" + day;
        returndatamothname = day + " " + getNameOfMonth(month_);
        fragmentSearchFlightBinding.txttodateretim.setText(getNameOfMonth(month_) + " " + year + " \n" + dayOfWeek);
        fragmentSearchFlightBinding.txttodatedegitretun.setText(day + "");

    }

    private String getNameOfMonth(int month_) {
        String monthName = "";
        if (month_ == 1) {
            monthName = "Jan";
        } else if (month_ == 2) {
            monthName = "Feb";
        } else if (month_ == 3) {
            monthName = "Mar";
        } else if (month_ == 4) {
            monthName = "Apr";
        } else if (month_ == 5) {
            monthName = "May";
        } else if (month_ == 6) {
            monthName = "Jun";
        } else if (month_ == 7) {
            monthName = "Jul";
        } else if (month_ == 8) {
            monthName = "Aug";
        } else if (month_ == 9) {
            monthName = "Sep";
        } else if (month_ == 10) {
            monthName = "Oct";
        } else if (month_ == 11) {
            monthName = "Nov";
        } else if (month_ == 12) {
            monthName = "Dec";
        }
        return monthName;
    }


    @Override
    public void onResume() {
        super.onResume();
        setData();

    }

    private void setData() {

        if (!pref.getAdult().isEmpty() && !pref.getChidren().isEmpty() && !pref.getInfrant().isEmpty()) {
            int count = Integer.parseInt(pref.getAdult()) + Integer.parseInt(pref.getChidren()) + Integer.parseInt(pref.getInfrant());
            if (count == 0) {
                fragmentSearchFlightBinding.txtTravllers.setText("01");
            } else {
                fragmentSearchFlightBinding.txtTravllers.setText("0" + count);
            }


        }
        if (!pref.getCabinClass().isEmpty()) {
            fragmentSearchFlightBinding.txtCabinClass.setText(pref.getCabinClass());
        } else {
            fragmentSearchFlightBinding.txtCabinClass.setText(getString(R.string.all));
        }


    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        setData();
    }

    private void listener() {

        fragmentSearchFlightBinding.rlOneWay.setOnClickListener(this);
        fragmentSearchFlightBinding.rlRoundTrip.setOnClickListener(this);
        fragmentSearchFlightBinding.txttodateretim.setOnClickListener(this);
        fragmentSearchFlightBinding.txttodate.setOnClickListener(this);
        fragmentSearchFlightBinding.rlSearch.setOnClickListener(this);
        fragmentSearchFlightBinding.rrFrom.setOnClickListener(this);
        fragmentSearchFlightBinding.rrTo.setOnClickListener(this);
        fragmentSearchFlightBinding.llTravellersandcabinclass.setOnClickListener(this);
        pref = new Pref(getContext());
        fragmentSearchFlightBinding.rlOneWay.callOnClick();

    }

    private void initialization() {

        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(getActivity());
        lbm.registerReceiver(receiver, new IntentFilter("filter_string"));
        LocalBroadcastManager lbmdatatime = LocalBroadcastManager.getInstance(getActivity());
        lbmdatatime.registerReceiver(receiver_datatime, new IntentFilter("datatime"));

    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == request_Code) {
            if (resultCode == RESULT_OK) {

            }
        }
    }

    private void setIntentValue() {
        int adult = 1, chidren = 1, infrant = 1, cabinclass = 1;
        if (!pref.getAdult().isEmpty() && !pref.getChidren().isEmpty() && !pref.getInfrant().isEmpty()) {
            adult = Integer.parseInt(pref.getAdult());
            chidren = Integer.parseInt(pref.getChidren());
            infrant = Integer.parseInt(pref.getInfrant());

        }
        if (!pref.getCabinClass().isEmpty()) {
            if (pref.getCabinClass().equalsIgnoreCase(getResources().getString(R.string.all))) {
                cabinclass = 1;
            } else if (pref.getCabinClass().equalsIgnoreCase(getResources().getString(R.string.economy))) {
                cabinclass = 2;
            } else if (pref.getCabinClass().equalsIgnoreCase(getResources().getString(R.string.premiumeconomy))) {
                cabinclass = 3;
            } else if (pref.getCabinClass().equalsIgnoreCase(getResources().getString(R.string.business))) {
                cabinclass = 4;

            } else if (pref.getCabinClass().equalsIgnoreCase(getResources().getString(R.string.premiumbusiness))) {
                cabinclass = 5;
            } else if (pref.getCabinClass().equalsIgnoreCase(getResources().getString(R.string.first))) {
                cabinclass = 6;
            }

        } else {

        }
        Intent intent = new Intent(getActivity(), ListingOfFlightActivity_.class);
        String ToSortName = fragmentSearchFlightBinding.txtToCitySortName.getText().toString();
        String FormSortName = fragmentSearchFlightBinding.txtCitySortName.getText().toString();
        String tocityName=fragmentSearchFlightBinding. txtcity.getText().toString();
        String fromcityName=fragmentSearchFlightBinding. txttocity.getText().toString();

        intent.putExtra("to", ToSortName);
        intent.putExtra("from", FormSortName);
        intent.putExtra("cityname", tocityName);
        intent.putExtra("fromcityname", fromcityName);
        intent.putExtra("flightadlval", adult + "");
        intent.putExtra("flightchldval", chidren + "");
        intent.putExtra("flightinfantval", infrant + "");
        intent.putExtra("flightbusinessclass", cabinclass + "");
        intent.putExtra("date_", todate + "");
        intent.putExtra("returndate", returndata + "");
        intent.putExtra("todatewithmotnname", todatewithmotnname + "");
        intent.putExtra("returndatamothname", returndatamothname + "");
        if(pref.getCabinClass().isEmpty())
        {
            intent.putExtra("cabinclass", "All");
        }
        else
        { intent.putExtra("cabinclass", pref.getCabinClass());

        }



        startActivity(intent);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llTravellersandcabinclass:
                Intent intentTravelandcabinclass = new Intent(getActivity(), TravellersandClassActivity.class);
                getActivity().startActivity(intentTravelandcabinclass);
                break;
            case R.id.rrTo:
                Intent intentListCityto = new Intent(getActivity(), CityListActivity.class);
                intentListCityto.putExtra("type", "to");
                getActivity().startActivity(intentListCityto);
                break;
            case R.id.rrFrom:
                Intent intentListCityfrom = new Intent(getActivity(), CityListActivity.class);
                intentListCityfrom.putExtra("type", "from");
                startActivity(intentListCityfrom);
                break;
            case R.id.rlSearch:
                setIntentValue();
                break;

            case R.id.rlOneWay:
                fragmentSearchFlightBinding.rlOneWay.setBackgroundResource(R.drawable.roundbutton);
                fragmentSearchFlightBinding.rlRoundTrip.setBackgroundResource(0);
                fragmentSearchFlightBinding.txtOnwWay.setTextColor(getResources().getColor(R.color.white));
                fragmentSearchFlightBinding.txtrountrip.setTextColor(getResources().getColor(R.color.black));
                fragmentSearchFlightBinding.txttodatedegitretun.setVisibility(View.INVISIBLE);
                fragmentSearchFlightBinding.txttodateretim.setVisibility(View.INVISIBLE);
                fragmentSearchFlightBinding.txtonewaytrip.setVisibility(View.VISIBLE);
                returndata = "";
                returndatamothname = "";
                break;
            case R.id.rlRoundTrip:
                fragmentSearchFlightBinding.txtonewaytrip.setVisibility(View.INVISIBLE);
                fragmentSearchFlightBinding.rlOneWay.setBackgroundResource(0);
                fragmentSearchFlightBinding.rlRoundTrip.setBackgroundResource(R.drawable.roundbutton);
                fragmentSearchFlightBinding.txtOnwWay.setTextColor(getResources().getColor(R.color.black));
                fragmentSearchFlightBinding.txtrountrip.setTextColor(getResources().getColor(R.color.white));
                fragmentSearchFlightBinding.txttodatedegitretun.setVisibility(View.VISIBLE);
                fragmentSearchFlightBinding.txttodateretim.setVisibility(View.VISIBLE);
                roundTripDetultdate();
                break;

            case R.id.txttodate:

                DialogFragment newFragmentto = new DatePickerFragment("todate", fragmentSearchFlightBinding);
                newFragmentto.show(getFragmentManager(), "datePicker");

                break;
            case R.id.txttodateretim:

                DialogFragment newFragmentFrom = new DatePickerFragment("toreturn", fragmentSearchFlightBinding);
                newFragmentFrom.show(getFragmentManager(), "datePicker");
                break;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        pref.setData("", "", "");
        pref.setCabinClass("");

    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        String type = "";
        FragmentSearchFlightBinding fragmentSearchFlightBinding;

        DatePickerFragment(String type, FragmentSearchFlightBinding fragmentSearchFlightBinding) {
            this.type = type;
            this.fragmentSearchFlightBinding = fragmentSearchFlightBinding;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);
            dialog.getDatePicker().setMinDate(c.getTimeInMillis());
            return dialog;
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // btnDate.setText(ConverterDate.ConvertDate(year, month + 1, day));
            int month_ = month + 1;
            String dayOfWeek = "", monthName = "";

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter dayOfWeekFormatter
                        = DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH);
                LocalDate date = LocalDate.of(
                        year, month + 1, day);
                dayOfWeek = date.format(dayOfWeekFormatter);
            }


            if (month_ == 1) {
                monthName = "Jan";
            } else if (month_ == 2) {
                monthName = "Feb";
            } else if (month_ == 3) {
                monthName = "Mar";
            } else if (month_ == 4) {
                monthName = "Apr";
            } else if (month_ == 5) {
                monthName = "May";
            } else if (month_ == 6) {
                monthName = "Jun";
            } else if (month_ == 7) {
                monthName = "Jul";
            } else if (month_ == 8) {
                monthName = "Aug";
            } else if (month_ == 9) {
                monthName = "Sep";
            } else if (month_ == 10) {
                monthName = "Oct";
            } else if (month_ == 11) {
                monthName = "Nov";
            } else if (month_ == 12) {
                monthName = "Dec";
            }

            if (type.equalsIgnoreCase("todate")) {


                Intent intent = new Intent("datatime");
                intent.putExtra("month", month_+"");
                intent.putExtra("type", "todate");
                intent.putExtra("monthName", monthName);
                intent.putExtra("year", year + "");
                intent.putExtra("day", day + "");
                intent.putExtra("dayOfWeek", dayOfWeek);
                LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intent);

            } else {
                Intent intent = new Intent("datatime");
                intent.putExtra("month", month_+"");
                intent.putExtra("type", "toreturn");
                intent.putExtra("monthName", monthName);
                intent.putExtra("year", year + "");
                intent.putExtra("day", day + "");
                intent.putExtra("dayOfWeek", dayOfWeek);
                LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intent);
            }
        }
    }


}
