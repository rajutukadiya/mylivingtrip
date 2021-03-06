package com.mylivingtrip.app.activity.flightlist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.mylivingtrip.app.R;
import com.mylivingtrip.app.activity.filterscreen.FilterActivity;
import com.mylivingtrip.app.databinding.ActivityListingOfFlightBinding;
import com.mylivingtrip.app.fragment.response.ListOfFightResponse;
import com.mylivingtrip.app.fragment.response.test;
import com.mylivingtrip.app.retrofit.ApiClient;
import com.mylivingtrip.app.retrofit.ApiInterface;
import com.mylivingtrip.app.utils.InternetConnection;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListingOfFlightActivity_ extends AppCompatActivity implements View.OnClickListener {


    private ActivityListingOfFlightBinding activityDashboardBinding;
    private RecyclerView.Adapter MyAdapterCalendarList, MyAdapterFlightList, MyAdapterFlightStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialization();

        listener();


    }


    private void initialization() {

        activityDashboardBinding = DataBindingUtil.setContentView(this, R.layout.activity_listing_of_flight);

        calendarList();

        sortbyandfilterlist();

        if (InternetConnection.checkConnection(getApplicationContext())) {
            getList();
        } else {
            Toast.makeText(this, "please check your internet connection", Toast.LENGTH_SHORT).show();
        }

        setTitel();

    }

    @SuppressLint("SetTextI18n")
    private void setTitel()
    {
        Intent intent = getIntent();
        String flightadlval = intent.getStringExtra("flightadlval");
        String flightchldval = intent.getStringExtra("flightchldval");
        String flightinfantval = intent.getStringExtra("flightinfantval");
        String tocityName = intent.getStringExtra("cityname");
        String fromcityname = intent.getStringExtra("fromcityname");

        activityDashboardBinding.txtsourcetodestination.setText(tocityName +" to "+ fromcityname);
       int total =Integer.parseInt(flightadlval)+
               Integer.parseInt(flightchldval)+
               Integer.parseInt(flightinfantval);
        String todatewithmotnname = intent.getStringExtra("todatewithmotnname");
        String returndatamothname = intent.getStringExtra("returndatamothname");
        String cabinclass = intent.getStringExtra("cabinclass");

        String fullDetails="";
        assert todatewithmotnname != null;
        if(!todatewithmotnname.isEmpty() && !returndatamothname.isEmpty())
        {
            fullDetails=todatewithmotnname + "-"+returndatamothname+ " | ";

        }
        else
        {
            fullDetails=todatewithmotnname+ " | ";

        }

        int flightchld= Integer. parseInt(flightchldval);
            int flightinfant= Integer. parseInt(flightinfantval);
            if(flightchld==0 && flightinfant==0)
            {
                if(Integer. parseInt(flightadlval)>1)
                {
                    fullDetails=fullDetails+" | "+flightadlval +" Adults | ";
                }
                else
                {
                    fullDetails=fullDetails+" "+flightadlval +" Adult | ";
                }


            }
            else
            {
                fullDetails=fullDetails+" "+total +" Travellers | ";
            }



        activityDashboardBinding.txtDetails.setText(fullDetails+""+cabinclass);
    }

    private void listener() {
        activityDashboardBinding.imgBackArror.setOnClickListener(this);

        activityDashboardBinding.rlSearch.setOnClickListener(this);
    }

    private void getList()
    {

        Intent intent = getIntent();
        String to = intent.getStringExtra("to");
        String from = intent.getStringExtra("from");
        String flightadlval = intent.getStringExtra("flightadlval");
        String flightchldval = intent.getStringExtra("flightchldval");
        String flightinfantval = intent.getStringExtra("flightinfantval");
        String flightbusinessclass = intent.getStringExtra("flightbusinessclass");
        String todate = intent.getStringExtra("date_");
        String returndata = intent.getStringExtra("returndata");

        Log.e("to",to);
        Log.e("from",from);
        Log.e("flightadlval",flightadlval);
        Log.e("flightchldval",flightchldval);
        Log.e("flightinfantval",flightinfantval);
        Log.e("flightbusinessclass",flightbusinessclass);
        Log.e("todate",todate+"");
        Log.e("returndata",returndata+"");

        if(returndata==null)
        {
            returndata="";
        }

        activityDashboardBinding.progressBar.setVisibility(View.VISIBLE);

            test task = new test("1","1","1","1",from,
                    to,"2",todate,"");

            ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<ListOfFightResponse> call = apiService.getFightList(task);

        call.enqueue(new Callback<ListOfFightResponse>() {
            @Override
            public void onResponse(Call<ListOfFightResponse> call, Response<ListOfFightResponse> response) {


                activityDashboardBinding.progressBar.setVisibility(View.GONE);
                Log.e("Success", new Gson().toJson(response.body()));
                Log.e("Respnse", response.code()+"");

                if(response.body()!=null)
                {
                    flightListing(response.body().getSearchresult(),response.body().getAirlines());
                }

            }

            @Override
            public void onFailure(Call<ListOfFightResponse> call, Throwable t) {
                activityDashboardBinding.progressBar.setVisibility(View.GONE);
                Toast.makeText(ListingOfFlightActivity_.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

                Log.e("@@@", t.getMessage());
            }
        });

    }

    private void sortbyandfilterlist() {

        activityDashboardBinding.rrSortbyadnfilter.setHasFixedSize(true);
        activityDashboardBinding.rrSortbyadnfilter.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<String> input = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }
        MyAdapterFlightStop = new MyAdapterFlightStop(input);
        activityDashboardBinding.rrSortbyadnfilter.setAdapter(MyAdapterFlightStop);
    }

    private void calendarList() {

        activityDashboardBinding.rrCalendar.setHasFixedSize(true);
        activityDashboardBinding.rrCalendar.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<String> input = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }
        MyAdapterCalendarList = new MyAdapterCalendarList(input);
        activityDashboardBinding.rrCalendar.setAdapter(MyAdapterCalendarList);

    }

    private void flightListing(ListOfFightResponse.SearchresultBean searchresult, ListOfFightResponse.AirlinesBean airlines) {
        activityDashboardBinding.rrListOfFlights.setHasFixedSize(true);
        activityDashboardBinding.rrListOfFlights.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        MyAdapterFlightList = new MyAdapterFlightList(searchresult.getFirst(),airlines);
        activityDashboardBinding.rrListOfFlights.setAdapter(MyAdapterFlightList);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.rlSearch:
                Intent intent = new Intent(ListingOfFlightActivity_.this, FilterActivity.class);

                startActivity(intent);
                break;
            case R.id.imgBackArror:
                finish();
                break;

        }
    }

    public class MyAdapterCalendarList extends RecyclerView.Adapter<MyAdapterCalendarList.ViewHolder> {
        private List<String> values;

        public MyAdapterCalendarList(List<String> myDataset) {
            values = myDataset;
        }

        @Override
        public MyAdapterCalendarList.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                   int viewType) {

            LayoutInflater inflater = LayoutInflater.from(
                    parent.getContext());
            View v =
                    inflater.inflate(R.layout.flight_calendar_list_row, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {

            final String name = values.get(position);


        }

        @Override
        public int getItemCount() {
            return values.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public View layout;


            public ViewHolder(View v) {
                super(v);
                layout = v;

            }
        }

    }

    public class MyAdapterFlightList extends RecyclerView.Adapter<MyAdapterFlightList.ViewHolder> {
        private List<ListOfFightResponse.SearchresultBean.FirstBean> firstBeans;
        private   ListOfFightResponse.AirlinesBean airlinesBean;
        public MyAdapterFlightList(List<ListOfFightResponse.SearchresultBean.FirstBean> myDataset, ListOfFightResponse.AirlinesBean airlines) {
            firstBeans = myDataset;
            airlinesBean=airlines;
        }

        @Override
        public MyAdapterFlightList.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {

            LayoutInflater inflater = LayoutInflater.from(
                    parent.getContext());
            View v =
                    inflater.inflate(R.layout.flight_listing_row, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }
        public String convertDate(Date d) {

            //You are getting server date as argument, parse your server response and then pass date to this method

            SimpleDateFormat sdfAmerica = new SimpleDateFormat("hh:mm");

            String actualTime = sdfAmerica.format(d);
            //Changed timezone
            TimeZone tzInAmerica = TimeZone.getTimeZone("CST");
            sdfAmerica.setTimeZone(tzInAmerica);

            String convertedTime = sdfAmerica.format(d);


            return convertedTime;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {


            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            try {
                Date dateto = format.parse(firstBeans.get(position).getOrigin().getDepTime());

                Date datefrom = format.parse(firstBeans.get(position).getDestination().getArrTime());

                holder.txtToTime.setText(convertDate(dateto));
                holder.txtFromTime.setText(convertDate(datefrom));
                holder.txttcityname.setText(firstBeans.get(position).getOrigin().getFromCity());
                holder.txtfromcity.setText(firstBeans.get(position).getDestination().getToCity());
                holder.txtPrice.setText("₹ "+firstBeans.get(position).getTotal_fare());

                if(firstBeans.get(position).getAirline()!=null)
                {
                   if(airlinesBean.get_$6E().getAirlineCode()==firstBeans.get(position).getAirline().getAirlineCode())
                   {

                       Glide.with(getApplicationContext())
                               .load(airlinesBean.get_$6E().getAirlineLogo())
                               .error(R.drawable.ic_flight)
                               .into( holder.imgFlight);
                   }


                }


            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        @Override
        public int getItemCount() {
            return firstBeans.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public View layout;
            private TextView  txtToTime,txttcityname,txtFromTime,txtfromcity,txtPrice;
            private ImageView imgFlight;

            public ViewHolder(View v) {
                super(v);
                layout = v;
                txtToTime=v.findViewById(R.id.txtToTime);
                txttcityname=v.findViewById(R.id.txttcityname);
                txtFromTime=v.findViewById(R.id.txtFromTime);
                txtfromcity=v.findViewById(R.id.txtfromcity);
                txtPrice=v.findViewById(R.id.txtPrice);
                imgFlight=v.findViewById(R.id.imgFlight);
            }
        }

    }

    public class MyAdapterFlightStop extends RecyclerView.Adapter<MyAdapterFlightStop.ViewHolder> {
        private List<String> values;

        public MyAdapterFlightStop(List<String> myDataset) {
            values = myDataset;
        }

        @Override
        public MyAdapterFlightStop.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {

            LayoutInflater inflater = LayoutInflater.from(
                    parent.getContext());
            View v =
                    inflater.inflate(R.layout.softandfilterstoprow, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {

            final String name = values.get(position);


        }

        @Override
        public int getItemCount() {
            return values.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public View layout;


            public ViewHolder(View v) {
                super(v);
                layout = v;

            }
        }

    }

}
