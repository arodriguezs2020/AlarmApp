package com.example.alarmapp

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

class TimePicker : android.app.DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val miVista = inflater.inflate(R.layout.time_picker,container, false)

        val btnHecho = miVista.findViewById<Button>(R.id.btnHecho)
        val timePicker = miVista.findViewById<TimePicker>(R.id.timePicker)

        btnHecho.setOnClickListener {
            val mActivity = activity as MainActivity
            if (Build.VERSION.SDK_INT >= 23) {
                mActivity.setearHora(timePicker.hour, timePicker.minute)
            } else {
                mActivity.setearHora(timePicker.currentHour, timePicker.currentMinute)
            }
            this.dismiss()
        }
        return miVista
    }
}