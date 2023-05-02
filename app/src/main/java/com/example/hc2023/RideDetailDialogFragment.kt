package com.example.hc2023

import android.content.res.Resources
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton


class RideDetailDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.fragment_ride_detail, container, false)

        val exitBtn: FloatingActionButton = rootView.findViewById(R.id.exit_btn)
        exitBtn.setOnClickListener {
            dismiss()
        }

        return rootView
    }

    // Resizing dialog based on screen size
    override fun onResume() {
        super.onResume()
        val window = dialog!!.window ?: return
        val params = window.attributes

        val widthPercent = 95.toFloat() / 100
        val heightPercent = 60.toFloat() / 100
        val dm = Resources.getSystem().displayMetrics
        val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }
        val percentWidth = rect.width() * widthPercent
        val percentHeight = rect.height() * heightPercent

        params.width = percentWidth.toInt()
        params.height = percentHeight.toInt()
        window.attributes = params
    }

}