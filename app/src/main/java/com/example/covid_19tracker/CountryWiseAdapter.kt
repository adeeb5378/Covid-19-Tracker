package com.example.covid_19tracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class CountryWiseAdapter(worldWiseActivity: WorldWiseActivity) : RecyclerView.Adapter<CountryViewHolder>() {

    private val items : ArrayList<Country> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.country_list,parent,false)
        val viewHolder =  CountryViewHolder(view)
//        view.setOnClickListener {
//            listner.onItemClicked(items[viewHolder.adapterPosition])
//        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val currentItem = items[position]
        holder.countryTv.text=currentItem.Country
        holder.tConfirmedTv.text = currentItem.TotalConfirmed.toString()
       // holder.nConfirmedTv.text=currentItem.NewConfirmed.toString()
        holder.tRecoveredTv.text=currentItem.TotalRecovered.toString()
        holder.tDeathTv.text=currentItem.TotalDeaths.toString()

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateNews(updatedItems : ArrayList<Country>)
    {
        items.clear()
        items.addAll(updatedItems)

        notifyDataSetChanged()
    }

}

class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val countryTv : TextView = itemView.findViewById(R.id.countryTV)
    val tConfirmedTv : TextView = itemView.findViewById(R.id.totalConfirmedTV)
    //val nConfirmedTv : TextView = itemView.findViewById(R.id.newConfirmedTV)
    val tRecoveredTv : TextView = itemView.findViewById(R.id.totalrecoveredTV)
    val tDeathTv : TextView = itemView.findViewById(R.id.totaldeathTV)

}

