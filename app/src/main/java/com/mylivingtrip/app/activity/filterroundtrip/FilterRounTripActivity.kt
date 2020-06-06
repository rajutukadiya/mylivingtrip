package com.mylivingtrip.app.activity.filterroundtrip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mylivingtrip.app.R
import com.mylivingtrip.app.databinding.ActivityFilterBinding
import com.mylivingtrip.app.databinding.ActivityFilterRounTripBinding
import java.util.ArrayList

class FilterRounTripActivity : AppCompatActivity() {

    lateinit var activityFilterRounTripBinding: ActivityFilterRounTripBinding;
    private var mAdapter: RecyclerView.Adapter<*>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityFilterRounTripBinding = DataBindingUtil.setContentView(this, R.layout.activity_filter_roun_trip);

        listOfAirline()
    }

    fun listOfAirline() {

        activityFilterRounTripBinding.rrReturn.setHasFixedSize(true)
        activityFilterRounTripBinding.rrReturn.setLayoutManager(LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false))
        val input = ArrayList<String>()
        for (i in 0..10) {
            input.add("Test$i")
        }
        mAdapter = MyAdapterAirline(input)
        activityFilterRounTripBinding.rrReturn.setAdapter(mAdapter)
    }

    inner class MyAdapterAirline(private val values: List<String>) : RecyclerView.Adapter<MyAdapterAirline.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup,
                                        viewType: Int): MyAdapterAirline.ViewHolder {

            val inflater = LayoutInflater.from(
                    parent.context)
            val v = inflater.inflate(R.layout.filter_airline_item_row, parent, false)
            return ViewHolder(v)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val name = values[position]


        }

        override fun getItemCount(): Int {
            return values.size
        }

        inner class ViewHolder(var layout: View) : RecyclerView.ViewHolder(layout)

    }
}
