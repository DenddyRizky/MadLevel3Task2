package com.example.madlevel3task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*

class PortalAdapter(private val portals: List<Portal>, private val clickListener: (Portal) -> Unit) : RecyclerView.Adapter<PortalAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortalAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return portals.size
    }

    override fun onBindViewHolder(holder: PortalAdapter.ViewHolder, position: Int) {
        holder.databind(portals[position], clickListener)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun databind(portal: Portal, clickListener: (Portal) -> Unit){
            itemView.tvPortalTitle.text = portal.portalTitle
            itemView.tvPortalUrl.text = portal.portalUrl
            itemView.setOnClickListener{
                clickListener(portal)
            }
        }
    }
}