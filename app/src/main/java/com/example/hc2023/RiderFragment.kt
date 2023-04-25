package com.example.hc2023

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RiderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RiderFragment : Fragment() {

    private val dummyData = listOf<RideModel>(
        RideModel("Apr 1 • 5pm", "Joey", "ITH Airport", "$10"),
        RideModel("Apr 10 • 7am", "Bob", "Syracuse Airport", "$20"),
        RideModel("Apr 1 • 5pm", "Joey", "ITH Airport", "$10"),
        RideModel("Apr 10 • 7am", "Bob", "Syracuse Airport", "$20"),
        RideModel("Apr 1 • 5pm", "Joey", "ITH Airport", "$10"),
        RideModel("Apr 10 • 7am", "Bob", "Syracuse Airport", "$20"),
        RideModel("Apr 1 • 5pm", "Joey", "ITH Airport", "$10"),
        RideModel("Apr 10 • 7am", "Bob", "Syracuse Airport", "$20")
        )

    private var filteredDataSet = listOf<RideModel>()

    private lateinit var searchView: SearchView
    private lateinit var rideAdapter: RideAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_rider, container, false)

        // Set up search view actions
        searchView = rootView.findViewById(R.id.search_view)
        searchView.setOnQueryTextListener( object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null && query.trim() != "") {
                    // Start search
                    filteredDataSet = dummyData.filter {
                        it.destination.contains(query, ignoreCase = true)
                    }
                } else {
                    // Reset search
                    rideAdapter.dataSet = dummyData
                }

                rideAdapter.dataSet = filteredDataSet
                rideAdapter.notifyDataSetChanged()

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // No actions
                return false
            }
        })

        val recyclerView: RecyclerView = rootView.findViewById(R.id.rides_list)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        rideAdapter = RideAdapter(dummyData)
        recyclerView.adapter = rideAdapter

        return rootView
    }

    companion object {
        fun newInstance() = RiderFragment()
    }
}