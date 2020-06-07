package com.example.india_covid19_tracker.ui.main

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.india_covid19_tracker.R
import com.example.india_covid19_tracker.StateDataViewModel
import com.example.india_covid19_tracker.StateDataViewModelFactory
import com.example.india_covid19_tracker.StatewiseItem
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        activity?.requestedOrientation =ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val view= inflater.inflate(R.layout.main_fragment,container,false)
        val application= requireNotNull(this.activity).application
        val factory=StateDataViewModelFactory(application)
        val mainviewModel=ViewModelProvider(this,factory).get(StateDataViewModel::class.java)
        mainviewModel.statelist.observe(viewLifecycleOwner, Observer {
            it.get(0).confirmed.let {
                TotalCount.text=it
            }
            it.get(0).active.let {
                ActiveCount.text=it
            }
            it.get(0).recovered.let{
                RecoveredCount.text=it
            }
        })

        val resultbtn=view.findViewById<Button>(R.id.state_button)
        resultbtn.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToStateDataFragment())
        }
        return view
    }

}