package com.mylivingtrip.app.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mylivingtrip.app.MainActivity;
import com.mylivingtrip.app.R;
import com.mylivingtrip.app.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView.Adapter mAdapter, MyAdapterCategory, MyAdapterHotspot, MyAdapterBanner,MyAdapterpopulardestinations;


    private String mParam1;
    private String mParam2;

    private FragmentHomeBinding fragmentHomeBinding;


    public HomeFragment() {
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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


        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        View rootView = fragmentHomeBinding.getRoot();
        banner();
        category();
        populardestinations();
        return rootView;


    }

    private void banner() {

        fragmentHomeBinding.rrBanner.setHasFixedSize(true);
        fragmentHomeBinding.rrBanner.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        List<String> input = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }
        MyAdapterBanner = new MyAdapterBanner(input);
        fragmentHomeBinding.rrBanner.setAdapter(MyAdapterBanner);
    }

    private void category() {
        fragmentHomeBinding.rrCatgory.setHasFixedSize(true);
        fragmentHomeBinding.rrCatgory.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        List<String> input = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            input.add("Test" + i);
        }
        MyAdapterCategory = new MyAdapterCategory(input);
        fragmentHomeBinding.rrCatgory.setAdapter(MyAdapterCategory);

    }

    private void populardestinations() {
        fragmentHomeBinding.rrPopularDestinations.setHasFixedSize(true);
        fragmentHomeBinding.rrPopularDestinations.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        List<String> input = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }
        MyAdapterpopulardestinations = new MyAdapterpopulardestinations(input);
        fragmentHomeBinding.rrPopularDestinations.setAdapter(MyAdapterpopulardestinations);
    }

    public class MyAdapterBanner extends RecyclerView.Adapter<MyAdapterBanner.ViewHolder> {
        private List<String> values;

        public MyAdapterBanner(List<String> myDataset) {
            values = myDataset;
        }

        @Override
        public MyAdapterBanner.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {

            LayoutInflater inflater = LayoutInflater.from(
                    parent.getContext());
            View v =
                    inflater.inflate(R.layout.banner_cantegory_item_row, parent, false);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int devicewidth = (int) (displayMetrics.widthPixels * 0.7);
            v.getLayoutParams().width = devicewidth;
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

    public class MyAdapterCategory extends RecyclerView.Adapter<MyAdapterCategory.ViewHolder> {
        private List<String> values;

        public MyAdapterCategory(List<String> myDataset) {
            values = myDataset;
        }

        @Override
        public MyAdapterCategory.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {

            LayoutInflater inflater = LayoutInflater.from(
                    parent.getContext());
            View v =
                    inflater.inflate(R.layout.category_item_row, parent, false);

            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {

            final String name = values.get(position);


            if(position==0)
            {
             holder.imageView.setImageResource(R.drawable.airplane);
             holder.txtName.setText("Flights");
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((MainActivity) getActivity()). setTitle(getString(R.string.searchflight));
                        ((MainActivity) getActivity()).addFragment(new SearchFlightFragment());

                    }
                });

            }
            else
                if(position==1)
                {
                    holder.imageView.setImageResource(R.drawable.hotel);
                    holder.txtName.setText("Hotel");
                }
                else
                    if(position==2)
                    {
                        holder.imageView.setImageResource(R.drawable.bus);
                        holder.txtName.setText("Bus");
                    }
                    else
                        if(position==3)
                        {
                            holder.imageView.setImageResource(R.drawable.holiday);
                            holder.txtName.setText("Holiday");
                        }


        }

        @Override
        public int getItemCount() {
            return values.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public View layout;
            private ImageView imageView;
            private TextView txtName;

            public ViewHolder(View v) {
                super(v);
                layout = v;
                imageView=v.findViewById(R.id.imgItem);
                txtName=v.findViewById(R.id.txtName);

            }
        }

    }

    public class MyAdapterpopulardestinations extends RecyclerView.Adapter<MyAdapterpopulardestinations.ViewHolder> {
        private List<String> values;

        public MyAdapterpopulardestinations(List<String> myDataset) {
            values = myDataset;
        }

        @Override
        public MyAdapterpopulardestinations.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {

            LayoutInflater inflater = LayoutInflater.from(
                    parent.getContext());
            View v =
                    inflater.inflate(R.layout.populardestinations_item_row, parent, false);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int devicewidth = (int) (displayMetrics.widthPixels * 0.7);
            v.getLayoutParams().width = devicewidth;
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