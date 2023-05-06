package com.example.hc2023

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * A simple [Fragment] subclass.
 * Use the [DriverFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DriverFragment : Fragment() {

    // TEST-ONLY
    //TODO: integrate w/ backend
    private var dummyData = listOf<RideModel>(
        RideModel("Apr 1 • 5pm", "Joey", "ITH Airport", "$10"),
        RideModel("Apr 10 • 7am", "Bob", "Syracuse Airport", "$20"),
        RideModel("Apr 1 • 5pm", "Joey", "ITH Airport", "$10"),
        RideModel("Apr 10 • 7am", "Bob", "Syracuse Airport", "$20"),
        RideModel("Apr 1 • 5pm", "Joey", "ITH Airport", "$10"),
        RideModel("Apr 10 • 7am", "Bob", "Syracuse Airport", "$20"),
        RideModel("Apr 1 • 5pm", "Joey", "ITH Airport", "$10"),
        RideModel("Apr 10 • 7am", "Bob", "Syracuse Airport", "$20")
    )

    private var networkTestData = listOf<PostModel>()

    private lateinit var driverRideAdapter: DriverRideAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_driver, container, false)

        // Network request to get rides
        activity?.let {
            getPosts(it) { posts ->
                //TODO: integrate w/ backend
                networkTestData = posts
                driverRideAdapter.dataSet = networkTestData
                driverRideAdapter.notifyDataSetChanged()
            }
        }

        // Setup recycler view
        val recyclerView: RecyclerView = rootView.findViewById(R.id.rides_list)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        driverRideAdapter = DriverRideAdapter(networkTestData)
        recyclerView.adapter = driverRideAdapter

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