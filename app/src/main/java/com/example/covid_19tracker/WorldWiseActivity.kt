package com.example.covid_19tracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_world_wise.*

class WorldWiseActivity : AppCompatActivity() {

    private lateinit var mAdapter:CountryWiseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_world_wise)

        recycleView.layoutManager = LinearLayoutManager(this)
        //fetchWorldWiseData()
        fetchData()
        mAdapter = CountryWiseAdapter(this)
        recycleView.adapter = mAdapter
    }

//    private fun fetchWorldWiseData() {
//        val url = "http://my-json-feed"
//
//        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
//                {
//                    val response = it.
//                },
//                {
//
//                }
//        )
//
//// Access the RequestQueue through your singleton class.
//        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
//    }

    private fun fetchData() {
        val url = "https://api.covid19api.com/summary"
        val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                {
                    val countryJsonArray = it.getJSONArray("Countries")
                    val globalJsonObject = it.getJSONObject("Global")
                    //Log.i("GlobalInfo",globalJsonObject.getString("NewConfirmed"))
                    //Log.i("InfoCountry",countryJsonArray.getString(0))
//                    NewConfirmed: 561661,
//                    TotalConfirmed: 136069313,
//                    NewDeaths: 8077,
//                    TotalDeaths: 2937292,
//                    NewRecovered: 487901,
//                    TotalRecovered: 77585186,
//                    Date: "2021-04-13T02:28:22.158Z"
                    val tConfirmed = globalJsonObject.getString("TotalConfirmed")
                    val confirmed = globalJsonObject.getString("NewConfirmed")
                    val recovered = globalJsonObject.getString("TotalRecovered")
                    val death = globalJsonObject.getString("TotalDeaths")
                    tConfirmedTv.text=tConfirmed
                    newConfirmedeTv.text=confirmed
                    recoveredTv.text=recovered
                    deceasedTv.text=death
                    val countryArray = ArrayList<Country>()
                    for (i in 0 until countryJsonArray.length()) {
                        val countryJsonObject = countryJsonArray.getJSONObject(i)
                        val country = Country(
                                countryJsonObject.getString("Country"),
                                countryJsonObject.getInt("TotalConfirmed"),
                                countryJsonObject.getInt("NewConfirmed"),
                                countryJsonObject.getInt("TotalRecovered"),
                                countryJsonObject.getInt("TotalDeaths")
                        )
                        countryArray.add(country)
                    }
                    mAdapter.updateNews(countryArray)


                },
                {

                }
        )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }




}

