package com.mylivingtrip.app.activity.filterscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mylivingtrip.app.R
import com.mylivingtrip.app.activity.filterscreen.Adapter.MyPagerAdapter
import com.mylivingtrip.app.databinding.ActivityFilterBinding
import kotlinx.android.synthetic.main.activity_filter.*

class FilterActivity : AppCompatActivity() {

    lateinit var activityFilterBinding: ActivityFilterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityFilterBinding = DataBindingUtil.setContentView(this, R.layout.activity_filter);

        initialization()

        listener()


    }

    fun initialization() {

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter
        tabs_main.setupWithViewPager(viewpager_main)

    }

    fun listener() {
        activityFilterBinding.imgBackArror.setOnClickListener {

            finish()
        }

    }


}
