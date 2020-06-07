package com.example.india_covid19_tracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StateDataFragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.state_data_fragment,container,false)
        val application= requireNotNull(this.activity).application
        val viewModelFactory=StateDataViewModelFactory(application)
        val viewModel=ViewModelProvider(this,viewModelFactory).get(StateDataViewModel::class.java)
        var adapter=StateNameAdapter(StateNameAdapter.OnClickListener{
            viewModel.displayPropertyDetails(it)
        })
        viewModel.statelist.observe(viewLifecycleOwner, Observer {
            it.let {
                adapter.list=it.subList(1,it.size)
            }
        })

        val recView=view.findViewById<RecyclerView>(R.id.Recyclerstatename)
        recView.layoutManager= LinearLayoutManager(this.context)
        recView.adapter=adapter
        viewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                // Must find the NavController from the Fragment
                this.findNavController().navigate(StateDataFragmentDirections.actionStateDataFragmentToStateRecord(it))
                // Tell the ViewModel we've made the navigate call to prevent multiple navigation
                viewModel.displayPropertyDetailsComplete()
            }
        })
        return view
    }
}