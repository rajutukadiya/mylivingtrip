package com.mylivingtrip.app.activity.homescreen

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.mylivingtrip.app.R
import com.mylivingtrip.app.activity.homescreen.response.CityResponse
import com.mylivingtrip.app.activity.homescreen.response.Flightcity
import com.mylivingtrip.app.databinding.ActivityCityNameListBinding
import com.mylivingtrip.app.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CityNameListActivity : AppCompatActivity() {

    var type: String = ""
    lateinit var activityCityNameListBinding: ActivityCityNameListBinding
    private var mAdapter: RecyclerView.Adapter<*>? = null

    var flightcityOrigin: List<Flightcity>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCityNameListBinding = DataBindingUtil.setContentView(this, R.layout.activity_city_name_list);
        if (isOnline(applicationContext)) {
            getCityList()
        } else {
            Toast.makeText(applicationContext, "Please check your internet connection", Toast.LENGTH_SHORT).show()
        }
        activityCityNameListBinding.imgBackArror.setOnClickListener {
            finish()
        }



    }

    fun getCityList() {
        activityCityNameListBinding.progressBar.visibility = View.VISIBLE
        RetrofitClient.instance.getCityList()
                .enqueue(object : Callback<CityResponse> {
                    override fun onFailure(call: Call<CityResponse>, t: Throwable) {
                        activityCityNameListBinding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<CityResponse>, response: Response<CityResponse>) {
                        activityCityNameListBinding.progressBar.visibility = View.GONE
                        Log.e("Success", Gson().toJson(response.body()))
                        Log.e("Respnse", response.toString())

                        val isStatus = response.body().status

                        if (isStatus) {

                            SetCityNameInList(response.body().flightcity);
                        } else {
                            Toast.makeText(applicationContext, "something went wrong", Toast.LENGTH_SHORT).show()
                        }
                    }
                })

    }

    fun SetCityNameInList(flightcity: List<Flightcity>) {
        flightcityOrigin=flightcity
        activityCityNameListBinding.rrCityList.setHasFixedSize(true)
        activityCityNameListBinding.rrCityList.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false))

        mAdapter = MyAdapterCityList(flightcity)
        activityCityNameListBinding.rrCityList.setAdapter(mAdapter)
    }
//https://github.com/johncodeos-blog/SearchRecyclerViewExample

    inner class MyAdapterCityList(private val flightcity: List<Flightcity>) : RecyclerView.Adapter<MyAdapterCityList.ViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup,
                                        viewType: Int): MyAdapterCityList.ViewHolder {

            val inflater = LayoutInflater.from(
                    parent.context)
            val v = inflater.inflate(R.layout.flight_city_list_row_item, parent, false)
            return ViewHolder(v)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            holder.txtcityname.setText(flightcity[position].airportCity + ", " + flightcity[position].airportCountry)
            holder.txtcityname_detail.setText(flightcity[position].airportName)
            holder.txtcityname_detail_sort_name.setText(flightcity[position].airportCode)
            holder.itemView.setOnClickListener {

                val intentt = getIntent()
                val type = intent.getStringExtra("type")
                val intent = Intent("filter_string")
                intent.putExtra("cityname", flightcity[position].airportCity)
                intent.putExtra("airportname", flightcity[position].airportName)
                intent.putExtra("airpostcode", flightcity[position].airportCode)
                intent.putExtra("type", type)
                LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(intent)
                finish()
            }

        }

        override fun getItemCount(): Int {
            return flightcity.size
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var txtcityname: TextView
            var txtcityname_detail: TextView
            var txtcityname_detail_sort_name: TextView

            init {
                this.txtcityname = itemView.findViewById(R.id.cityname) as TextView
                this.txtcityname_detail = itemView.findViewById(R.id.cityname_detail) as TextView
                this.txtcityname_detail_sort_name = itemView.findViewById(R.id.cityname_detail_sort_name) as TextView
            }
        }

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

