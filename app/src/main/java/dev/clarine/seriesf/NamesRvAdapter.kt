package dev.clarine.seriesf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import dev.clarine.recyclerviews.R

class NamesRvAdapter(var namesList: List<Int>): RecyclerView.Adapter<NamesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesViewHolder {
        val itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.name_list_item,parent,false)
        return NamesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NamesViewHolder, position: Int) {
       val currentName=namesList.get(position)
           holder.tvName.text= currentName.toString()
    }

    override fun getItemCount(): Int {
      return namesList.size
    }
}
class NamesViewHolder(itemView: View):ViewHolder(itemView){
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
}