package com.example.hc2023

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DriverRideAdapter(
    //TODO: integrate w/ backend
    var dataSet: List<RideModel>) :
    RecyclerView.Adapter<DriverRideAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val usernameTV: TextView = view.findViewById(R.id.username_tv)
        val dateTV: TextView = view.findViewById(R.id.date_tv)
        val startTV: TextView = view.findViewById(R.id.start_location_tv)
        val destinationTV: TextView = view.findViewById(R.id.destination_tv)
        val priceTV: TextView = view.findViewById(R.id.price_tv)
        val riderCountTV: TextView = view.findViewById(R.id.rider_count_tv)
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): DriverRideAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.ride_history_row_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // skip for now
        viewHolder.usernameTV.text = dataSet[position].driver.name
        viewHolder.priceTV.text = dataSet[position].payment
        viewHolder.destinationTV.text = dataSet[position].destination

        val ridersCount = dataSet[position].passengers.count()
        if (ridersCount == 1) {
            viewHolder.riderCountTV.text = ridersCount.toString() + " rider"
        } else {
            viewHolder.riderCountTV.text = ridersCount.toString() + " riders"
        }

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}