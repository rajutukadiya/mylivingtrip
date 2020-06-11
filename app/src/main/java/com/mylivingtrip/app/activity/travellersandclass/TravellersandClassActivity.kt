package com.mylivingtrip.app.activity.travellersandclass

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mylivingtrip.app.R
import com.mylivingtrip.app.databinding.ActivityTravellersandClassBinding
import com.mylivingtrip.app.utils.Pref

class TravellersandClassActivity : AppCompatActivity(), View.OnClickListener {

    var finalCountOne = 1
    var finalCountTwo = 1
    var finalCountThree = 1

    var pref: Pref? = null

    lateinit var activityTravellersandClassBinding: ActivityTravellersandClassBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityTravellersandClassBinding = DataBindingUtil.setContentView(this, R.layout.activity_travellersand_class);

        initialization()

        listener()

    }

    fun initialization() {

        pref = Pref(applicationContext);


        getLocalSetData()
    }

    fun getLocalSetData() {
        val adult = pref!!.adult
        val childer = pref!!.chidren
        val childInfran = pref!!.infrant
        val cabinclass = pref!!.cabinClass

        if (!adult.isEmpty()) {
            activityTravellersandClassBinding.txtTotal.text = adult.toString()
            finalCountOne = activityTravellersandClassBinding.txtTotal.text.toString().toInt()

        }
        else
        {
            if (finalCountOne >= 0) {
                activityTravellersandClassBinding.txtTotal.text = finalCountOne.toString()


            }
        }
        if (!childer.isEmpty()) {
            activityTravellersandClassBinding.txtTotalChildren.text = childer.toString()
            finalCountTwo = activityTravellersandClassBinding.txtTotalChildren.text.toString().toInt()
        }
        if (!childInfran.isEmpty()) {
            activityTravellersandClassBinding.txtTotalInfrant.text = childInfran.toString()
            finalCountThree = activityTravellersandClassBinding.txtTotalInfrant.text.toString().toInt()
        }

        if (!cabinclass.isEmpty()) {
            if (cabinclass.toString().equals(getString(R.string.all))) {
                allSelector()
            } else if (cabinclass.toString().equals(getString(R.string.premiumeconomy))) {
                premiumeconomySelector()
            } else if (cabinclass.toString().equals(getString(R.string.economy))) {
                economySelector()
            } else if (cabinclass.toString().equals(getString(R.string.business))) {
                bussinessSelector()

            } else if (cabinclass.toString().equals(getString(R.string.premiumbusiness))) {
                premiumBusinessSelector()
            } else if (cabinclass.toString().equals(getString(R.string.first))) {
                firstSelector()
            }

        }
        else
        {
            allSelector()
        }
    }

    fun listener() {

        activityTravellersandClassBinding.imgArror.setOnClickListener(this)
        activityTravellersandClassBinding.btnAll.setOnClickListener(this)
        activityTravellersandClassBinding.btnPreminumEconomy.setOnClickListener(this)
        activityTravellersandClassBinding.btnEconomy.setOnClickListener(this)
        activityTravellersandClassBinding.btnBussines.setOnClickListener(this)
        activityTravellersandClassBinding.btnPremiumBussiness.setOnClickListener(this)
        activityTravellersandClassBinding.btnFirst.setOnClickListener(this)

        activityTravellersandClassBinding.txtPlus.setOnClickListener(this)
        activityTravellersandClassBinding.txtMus.setOnClickListener(this)

        activityTravellersandClassBinding.txtPlusChildren.setOnClickListener(this)
        activityTravellersandClassBinding.txtMuschildren.setOnClickListener(this)

        activityTravellersandClassBinding.txtPlusInfant.setOnClickListener(this)
        activityTravellersandClassBinding.txtMusinfant.setOnClickListener(this)

        activityTravellersandClassBinding.rlDone.setOnClickListener(this)
    }

    fun calData(): Int {
        var finalcountTotal = activityTravellersandClassBinding.txtTotal.text.toString().toInt()
        var finalcountChildren = activityTravellersandClassBinding.txtTotalChildren.text.toString().toInt()
        var finalcountInfrant = activityTravellersandClassBinding.txtTotalInfrant.text.toString().toInt()
        val total = finalcountTotal + finalcountChildren + finalcountInfrant

        return total
    }

    override fun onClick(vew: View?) {

        when (vew?.id) {
            R.id.rlDone->
            {
                finish()
            }
            R.id.txtPlus -> {

                if (finalCountOne >= 0) {


                    if (calData() < 9)
                    {
                        finalCountOne = finalCountOne + 1
                        var finalcountTotal = activityTravellersandClassBinding.txtTotal.text.toString().toInt()
                        var finalcountChildren = activityTravellersandClassBinding.txtTotalChildren.text.toString().toInt()
                        var finalcountInfrant = activityTravellersandClassBinding.txtTotalInfrant.text.toString().toInt()
                        pref!!.setData(finalCountOne.toString(), finalcountChildren.toString(), finalcountInfrant.toString())
                    }


                    else
                        Toast.makeText(this, "Upto 9 passengers can be booked at a time", Toast.LENGTH_SHORT).show()

                    activityTravellersandClassBinding.txtTotal.text = finalCountOne.toString()
                    if (finalCountOne == 0) {
                        finalCountOne = 1
                    }
                }

            }
            R.id.txtMus -> {
                if (finalCountOne > 1) {

                    finalCountOne = finalCountOne - 1
                    var finalcountChildren = activityTravellersandClassBinding.txtTotalChildren.text.toString().toInt()
                    var finalcountInfrant = activityTravellersandClassBinding.txtTotalInfrant.text.toString().toInt()
                    pref!!.setData(finalCountOne.toString(), finalcountChildren.toString(), finalcountInfrant.toString())
                    activityTravellersandClassBinding.txtTotal.text = finalCountOne.toString()



                }
            }
            R.id.txtPlusChildren -> {
                if (finalCountTwo >= 0) {


                    if (calData() < 9)
                    {
                        finalCountTwo = finalCountTwo + 1
                        var finalcountTotal = activityTravellersandClassBinding.txtTotal.text.toString().toInt()
                        var finalcountChildren = activityTravellersandClassBinding.txtTotalChildren.text.toString().toInt()
                        var finalcountInfrant = activityTravellersandClassBinding.txtTotalInfrant.text.toString().toInt()
                        pref!!.setData(finalcountTotal.toString(), finalCountTwo.toString(), finalcountInfrant.toString())
                    }

                    else
                        Toast.makeText(this, "Upto 9 passengers can be booked at a time", Toast.LENGTH_SHORT).show()
                    activityTravellersandClassBinding.txtTotalChildren.text = finalCountTwo.toString()
                                if (finalCountTwo == 0) {
                        finalCountTwo = 1
                    }
                }
            }
            R.id.txtMuschildren -> {
                if (finalCountTwo >= 0) {
                    finalCountTwo = finalCountTwo - 1
                    activityTravellersandClassBinding.txtTotalChildren.text = finalCountTwo.toString()
                    var finalcountChildren = activityTravellersandClassBinding.txtTotalChildren.text.toString().toInt()
                    var finalcountInfrant = activityTravellersandClassBinding.txtTotalInfrant.text.toString().toInt()
                    pref!!.setData(finalCountOne.toString(), finalcountChildren.toString(), finalcountInfrant.toString())
                    if (finalCountTwo == 0) {
                        finalCountTwo = 1
                    }

                }
            }
            R.id.txtPlusInfant -> {
                if (finalCountThree >= 0) {


                    if (calData() < 9)

                    {
                        finalCountThree = finalCountThree + 1
                        var finalcountTotal = activityTravellersandClassBinding.txtTotal.text.toString().toInt()
                        var finalcountChildren = activityTravellersandClassBinding.txtTotalChildren.text.toString().toInt()
                        var finalcountInfrant = activityTravellersandClassBinding.txtTotalInfrant.text.toString().toInt()
                        pref!!.setData(finalcountTotal.toString(), finalcountChildren.toString(), finalCountThree.toString())
                    }
                    else
                        Toast.makeText(this, "Upto 9 passengers can be booked at a time", Toast.LENGTH_SHORT).show()
                    activityTravellersandClassBinding.txtTotalInfrant.text = finalCountThree.toString()
                    calData()
                    if (finalCountThree == 0) {
                        finalCountThree = 1
                    }
                }
            }
            R.id.txtMusinfant -> {
                if (finalCountThree >= 0) {
                    finalCountThree = finalCountThree - 1
                    activityTravellersandClassBinding.txtTotalInfrant.text = finalCountThree.toString()
                    var finalcountChildren = activityTravellersandClassBinding.txtTotalChildren.text.toString().toInt()
                    var finalcountInfrant = activityTravellersandClassBinding.txtTotalInfrant.text.toString().toInt()
                    pref!!.setData(finalCountOne.toString(), finalcountChildren.toString(), finalcountInfrant.toString())
                    if (finalCountThree == 0) {
                        finalCountThree = 1
                    }
                }
            }
            R.id.imgArror -> {
                finish()
            }
            R.id.btnAll -> {
                allSelector()
            }
            R.id.btnPreminumEconomy -> {
                premiumeconomySelector()
            }
            R.id.btnEconomy -> {
                economySelector()
            }
            R.id.btnBussines -> {
                bussinessSelector()
            }
            R.id.btnPremiumBussiness -> {
                premiumBusinessSelector()
            }
            R.id.btnFirst -> {
                firstSelector()
            }
        }
    }


    fun allSelector() {
        activityTravellersandClassBinding.btnAll.setBackgroundResource(R.drawable.roundbutton)
        activityTravellersandClassBinding.btnPreminumEconomy.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnEconomy.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnBussines.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnPremiumBussiness.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnFirst.setBackgroundResource(R.drawable.roundselecter)

        activityTravellersandClassBinding.btnAll.setTextColor(resources.getColor(R.color.white))
        activityTravellersandClassBinding.btnPreminumEconomy.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnEconomy.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnBussines.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnPremiumBussiness.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnFirst.setTextColor(resources.getColor(R.color.colorAccent))
        pref!!.setCabinClass(activityTravellersandClassBinding.btnAll.text.toString())


    }

    fun premiumeconomySelector() {

        activityTravellersandClassBinding.btnAll.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnPreminumEconomy.setBackgroundResource(R.drawable.roundbutton)
        activityTravellersandClassBinding.btnEconomy.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnBussines.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnPremiumBussiness.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnFirst.setBackgroundResource(R.drawable.roundselecter)

        activityTravellersandClassBinding.btnAll.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnPreminumEconomy.setTextColor(resources.getColor(R.color.white))
        activityTravellersandClassBinding.btnEconomy.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnBussines.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnPremiumBussiness.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnFirst.setTextColor(resources.getColor(R.color.colorAccent))
        pref!!.setCabinClass(activityTravellersandClassBinding.btnPreminumEconomy.text.toString())

    }

    fun economySelector() {

        activityTravellersandClassBinding.btnAll.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnPreminumEconomy.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnEconomy.setBackgroundResource(R.drawable.roundbutton)
        activityTravellersandClassBinding.btnBussines.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnPremiumBussiness.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnFirst.setBackgroundResource(R.drawable.roundselecter)

        activityTravellersandClassBinding.btnAll.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnPreminumEconomy.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnEconomy.setTextColor(resources.getColor(R.color.white))
        activityTravellersandClassBinding.btnBussines.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnPremiumBussiness.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnFirst.setTextColor(resources.getColor(R.color.colorAccent))
        pref!!.setCabinClass(activityTravellersandClassBinding.btnEconomy.text.toString())
    }

    fun bussinessSelector() {
        activityTravellersandClassBinding.btnAll.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnPreminumEconomy.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnEconomy.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnBussines.setBackgroundResource(R.drawable.roundbutton)
        activityTravellersandClassBinding.btnPremiumBussiness.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnFirst.setBackgroundResource(R.drawable.roundselecter)

        activityTravellersandClassBinding.btnAll.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnPreminumEconomy.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnEconomy.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnBussines.setTextColor(resources.getColor(R.color.white))
        activityTravellersandClassBinding.btnPremiumBussiness.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnFirst.setTextColor(resources.getColor(R.color.colorAccent))

        pref!!.setCabinClass(activityTravellersandClassBinding.btnBussines.text.toString())

    }

    fun premiumBusinessSelector() {
        activityTravellersandClassBinding.btnAll.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnPreminumEconomy.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnEconomy.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnBussines.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnPremiumBussiness.setBackgroundResource(R.drawable.roundbutton)
        activityTravellersandClassBinding.btnFirst.setBackgroundResource(R.drawable.roundselecter)

        activityTravellersandClassBinding.btnAll.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnPreminumEconomy.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnEconomy.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnBussines.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnPremiumBussiness.setTextColor(resources.getColor(R.color.white))
        activityTravellersandClassBinding.btnFirst.setTextColor(resources.getColor(R.color.colorAccent))


        pref!!.setCabinClass(activityTravellersandClassBinding.btnPremiumBussiness.text.toString())
    }

    fun firstSelector() {
        activityTravellersandClassBinding.btnAll.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnPreminumEconomy.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnEconomy.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnBussines.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnPremiumBussiness.setBackgroundResource(R.drawable.roundselecter)
        activityTravellersandClassBinding.btnFirst.setBackgroundResource(R.drawable.roundbutton)

        activityTravellersandClassBinding.btnAll.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnPreminumEconomy.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnEconomy.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnBussines.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnPremiumBussiness.setTextColor(resources.getColor(R.color.colorAccent))
        activityTravellersandClassBinding.btnFirst.setTextColor(resources.getColor(R.color.white))

        pref!!.setCabinClass(activityTravellersandClassBinding.btnFirst.text.toString())

    }


}
