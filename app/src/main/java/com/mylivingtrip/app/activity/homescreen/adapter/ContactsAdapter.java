package com.mylivingtrip.app.activity.homescreen.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mylivingtrip.app.R;
import com.mylivingtrip.app.activity.homescreen.response.CityResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravi on 16/11/17.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder>
        implements Filterable  {
    private Context context;
    private List<CityResponse.FlightcityBean> contactList;
    private List<CityResponse.FlightcityBean> contactListFiltered;
    private ContactsAdapterListener listener;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView cityname, cityname_detail,cityname_detail_sort_name;

        public MyViewHolder(View view) {
            super(view);
            cityname = view.findViewById(R.id.cityname);
            cityname_detail = view.findViewById(R.id.cityname_detail);
            cityname_detail_sort_name= view.findViewById(R.id.cityname_detail_sort_name);
           view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    listener.onContactSelected(contactListFiltered.get(getAdapterPosition()));
                }
            });
        }
    }


    public ContactsAdapter(Context context, List<CityResponse.FlightcityBean> contactList, ContactsAdapterListener listener) {
        this.context = context;
        this.listener = listener;
        this.contactList = contactList;
        this.contactListFiltered = contactList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flight_city_list_row_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final CityResponse.FlightcityBean contact = contactListFiltered.get(position);
        holder.cityname.setText(contact.getAirportCity()+", "+contact.getAirportCountry());
        holder.cityname_detail.setText(contact.getAirportCountry());

        holder.cityname_detail_sort_name.setText(contact.getAirportCode());

    }

    @Override
    public int getItemCount() {
        return contactListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    contactListFiltered = contactList;
                } else {
                    List<CityResponse.FlightcityBean> filteredList = new ArrayList<>();
                    for (CityResponse.FlightcityBean row : contactList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getAirportCity().toLowerCase().contains(charString.toLowerCase()) || row.getAirportCountry().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    contactListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = contactListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                contactListFiltered = (ArrayList<CityResponse.FlightcityBean>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface ContactsAdapterListener {
        void onContactSelected(CityResponse.FlightcityBean flightcityBean);
    }
}
