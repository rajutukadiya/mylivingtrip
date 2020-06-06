package com.mylivingtrip.app.activity.filterscreen.tabfrgament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mylivingtrip.app.R
import com.mylivingtrip.app.databinding.FragmentFiltersBinding
import com.mylivingtrip.app.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_filters.*
import java.util.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FiltersFragment : Fragment() {


    private var param1: String? = null
    private var param2: String? = null

    private var rootView: View? = null

    private var mAdapter: RecyclerView.Adapter<*>? = null


    lateinit var fragmentFiltersBinding: FragmentFiltersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        fragmentFiltersBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_filters, container, false)

        rootView = fragmentFiltersBinding.getRoot()

        initialization()

        listener()

        return rootView
    }


    fun initialization() {

        listOfAirline()
    }

    fun listener() {

    }

    fun listOfAirline() {

        fragmentFiltersBinding.rrAirline.setHasFixedSize(true)
        fragmentFiltersBinding.rrAirline.setLayoutManager(LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false))
        val input = ArrayList<String>()
        for (i in 0..10) {
            input.add("Test$i")
        }
        mAdapter = MyAdapterAirline(input)
        fragmentFiltersBinding. rrAirline.setAdapter(mAdapter)
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
