package com.example.hc2023

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton


/**
 * A simple [Fragment] subclass.
 * Use the [DriverFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DriverFragment : Fragment() {

    // TEST-ONLY
    //TODO: integrate w/ backend
    private var dummyData = listOf<RideModel>(
//        RideModel("Apr 1 • 5pm", "Joey", "ITH Airport", "$10"),
//        RideModel("Apr 10 • 7am", "Bob", "Syracuse Airport", "$20"),
//        RideModel("Apr 1 • 5pm", "Joey", "ITH Airport", "$10"),
//        RideModel("Apr 10 • 7am", "Bob", "Syracuse Airport", "$20"),
//        RideModel("Apr 1 • 5pm", "Joey", "ITH Airport", "$10"),
//        RideModel("Apr 10 • 7am", "Bob", "Syracuse Airport", "$20"),
//        RideModel("Apr 1 • 5pm", "Joey", "ITH Airport", "$10"),
//        RideModel("Apr 10 • 7am", "Bob", "Syracuse Airport", "$20")
    )

    private var networkDataSet = listOf<RideModel>()

    private lateinit var driverRideAdapter: DriverRideAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_driver, container, false)

        val newRideCollapseView : View = rootView.findViewById(R.id.new_ride_collapse_view)

//        val startLocationEdit : EditText = rootView.findViewById(R.id.start_location_edit)
//        val destinationEdit : EditText = rootView.findViewById(R.id.destination_edit)
//        val departureBtn: Button = rootView.findViewById(R.id.departure_btn)
//        val arrivalBtn: Button = rootView.findViewById(R.id.arrival_btn)
//        val fareEdit: Button = rootView.findViewById(R.id.fare_edit)
//        val contactEd: Button = rootView.findViewById(R.id.fare_edit)


        // Network request to get rides
        activity?.let {
            getPastRides(it) { rides ->
                networkDataSet = rides
                driverRideAdapter.dataSet = networkDataSet
                driverRideAdapter.notifyDataSetChanged()
            }
        }

        // Setup recycler view
        val recyclerView: RecyclerView = rootView.findViewById(R.id.rides_list)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        driverRideAdapter = DriverRideAdapter(networkDataSet)
        recyclerView.adapter = driverRideAdapter

        // Setup toggle new ride button
        val newRideToggleBtn : FloatingActionButton = rootView.findViewById(R.id.toggle_new_ride_btn)
        newRideToggleBtn.setOnClickListener {
            if (newRideCollapseView.visibility == View.GONE) {
                newRideCollapseView.visibility = View.VISIBLE
            } else {
                newRideCollapseView.visibility = View.GONE
            }
        }

        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment DriverFragment.
         */
        fun newInstance() = DriverFragment()
    }
}