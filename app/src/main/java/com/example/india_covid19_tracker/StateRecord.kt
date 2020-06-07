package com.example.india_covid19_tracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_state_record.*
import kotlinx.android.synthetic.main.main_fragment.view.*

class StateRecord : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_state_record, container, false)
        val statewiseItem=StateRecordArgs.fromBundle(requireArguments()).stateDetails

        val stotal=view.findViewById<TextView>(R.id.statetotal)
        stotal.text=statewiseItem.confirmed
        val sactive=view.findViewById<TextView>(R.id.stateactive)
        sactive.text=statewiseItem.active
        val srecovered=view.findViewById<TextView>(R.id.staterecovered)
        srecovered.text=statewiseItem.recovered
        val supdated=view.findViewById<TextView>(R.id.statedaily)
        supdated.text=statewiseItem.deltaconfirmed
        return view
    }

}