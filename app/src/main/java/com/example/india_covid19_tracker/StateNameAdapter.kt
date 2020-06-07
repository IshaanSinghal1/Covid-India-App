package com.example.india_covid19_tracker


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.india_covid19_tracker.StateNameAdapter.ViewHolder

class StateNameAdapter(val onClickListener: OnClickListener) : RecyclerView.Adapter<ViewHolder>(){
    var list=listOf<StatewiseItem>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val view=layoutInflater.inflate(R.layout.state_name_box,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val statewiseItem=list[position]
        holder.numIndex.text = (position+1).toString()
        holder.nameofstate.text=list[position].state
        holder.itemView.setOnClickListener {
            onClickListener.onClick(statewiseItem)
        }
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var numIndex=itemView.findViewById<TextView>(R.id.stateIndex)
        var nameofstate=itemView.findViewById<TextView>(R.id.stateName)
    }
    class OnClickListener(val clickListener:(statewiseItem: StatewiseItem)->Unit){
        fun onClick(statewiseItem: StatewiseItem)=clickListener(statewiseItem)
    }
}