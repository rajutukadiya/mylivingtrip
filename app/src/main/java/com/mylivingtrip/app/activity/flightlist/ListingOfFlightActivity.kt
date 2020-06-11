package com.mylivingtrip.app.activity.flightlist

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.mylivingtrip.app.R
import com.mylivingtrip.app.activity.homescreen.response.CityResponse
import com.mylivingtrip.app.databinding.ActivityListingOfFlightBinding
import com.mylivingtrip.app.fragment.response.ListOfFightResponse
import com.mylivingtrip.app.retrofit.RetrofitClient
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ListingOfFlightActivity : AppCompatActivity() {

    lateinit var activityListingOfFlightBinding: ActivityListingOfFlightBinding
    private var mAdapter: RecyclerView.Adapter<*>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityListingOfFlightBinding = DataBindingUtil.setContentView(this, R.layout.activity_listing_of_flight);



        if (isOnline(applicationContext)) {
            getFlightList()
        } else {
            Toast.makeText(applicationContext, "Please check your internet connection", Toast.LENGTH_SHORT).show()
        }
    }

    fun listofFlight() {

        activityListingOfFlightBinding.rrListOfFlights.setHasFixedSize(true)
        activityListingOfFlightBinding.rrListOfFlights.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false))
        val input = ArrayList<String>()
        for (i in 0..10) {
            input.add("Test$i")
        }
        mAdapter = MyAdapterAirline(input)
        activityListingOfFlightBinding.rrListOfFlights.setAdapter(mAdapter)
    }


    fun getFlightList() {
        try {


            val paramObject: JSONObject? = null
            paramObject?.put("flight_adl_val", "1")
            paramObject?.put("flight_chld_val", "1")
            paramObject?.put("flight_infant_val", "1")
            paramObject?.put("flightType", "1")
            paramObject?.put("flightFrom", "DEL")
            paramObject?.put("flightTo", "BOM")
            paramObject?.put("flight_business_class", "2")
            paramObject?.put("departDt", "2020-07-10")
            paramObject?.put("returnDt", "2020-07-17")


            activityListingOfFlightBinding.progressBar.visibility = View.VISIBLE
            paramObject?.let {
                RetrofitClient.instance.getSerachList(it)
                        .enqueue(object : Callback<ListOfFightResponse> {
                            override fun onFailure(call: Call<ListOfFightResponse>, t: Throwable) {
                                activityListingOfFlightBinding.progressBar.visibility = View.GONE
                                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                            }

                            override fun onResponse(call: Call<ListOfFightResponse>, response: Response<ListOfFightResponse>) {
                                activityListingOfFlightBinding.progressBar.visibility = View.GONE
                                Log.e("Success", Gson().toJson(response.body()))
                                Log.e("Respnse", response.toString())

                               /* val isStatus = response.body().status

                                if (isStatus) {

                                    //SetCityNameInList(response.body().flightcity);
                                } else {
                                    Toast.makeText(applicationContext, "something went wrong", Toast.LENGTH_SHORT).show()
                                }*/
                            }
                        })
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
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


    fun isOnline(context: Context): Boolean {
        val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                        } else {
                            TODO("VERSION.SDK_INT < M")
                        }
                    } else {
                        TODO("VERSION.SDK_INT < LOLLIPOP")
                    }
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }
}
