package com.example.hc2023

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RideAdapter(
    //TODO: integrate w/ backend
    var dataSet: List<PostModel>) :
    RecyclerView.Adapter<RideAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val destinationTV: TextView = view.findViewById(R.id.destination_tv)
        val dateTimeTV: TextView = view.findViewById(R.id.date_time_tv)
        val priceTV: TextView = view.findViewById(R.id.price_tv)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.ride_row_item, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        //TODO: integrate w/ backend
        viewHolder.destinationTV.text = dataSet[position].title
        viewHolder.dateTimeTV.text = dataSet[position].body
        viewHolder.priceTV.text = dataSet[position].hashedPoster
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}
