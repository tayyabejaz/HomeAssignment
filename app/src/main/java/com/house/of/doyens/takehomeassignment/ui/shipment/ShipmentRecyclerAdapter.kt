package com.house.of.doyens.takehomeassignment.ui.shipment

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.house.of.doyens.takehomeassignment.R
import com.house.of.doyens.takehomeassignment.data.ShipmentModel
import com.house.of.doyens.takehomeassignment.data.ShipmentStatusType

class ShipmentRecyclerAdapter(val context: Context, var data : List<ShipmentModel>,val itemClick: () -> Unit) : RecyclerView.Adapter<ShipmentRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShipmentRecyclerViewHolder {
        return ShipmentRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_shipment, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ShipmentRecyclerViewHolder, position: Int) {
        val holderItem = data[position]
        if (holderItem.status == ShipmentStatusType.InProgress.name){
            holder.status.setTextColor(ContextCompat.getColor(context,R.color.progress_color))
        } else if(holderItem.status == ShipmentStatusType.Completed.name){
            holder.status.setTextColor(ContextCompat.getColor(context,R.color.grey_color))
        }else if (holderItem.status == ShipmentStatusType.Loading.name){
            holder.status.setTextColor(ContextCompat.getColor(context,R.color.blue_color))
        }
        else if (holderItem.status == ShipmentStatusType.Pending.name){
            holder.status.setTextColor(ContextCompat.getColor(context,R.color.orange_color))
        }
        holder.status.text = holderItem.status
        holder.statusDescription.text = holderItem.statusDescription
        holder.statusUpdate.text = holderItem.statusUpdate
        holder.shipmentPrice.text = "$ ${holderItem.shipmentAmount} USD"
        holder.shipmentData.text = holderItem.shipmentDate
        holder.itemView.rootView.setOnClickListener {
            itemClick()
        }
    }
}

class ShipmentRecyclerViewHolder(itemView: View) : ViewHolder(itemView) {
    var status = itemView.findViewById<TextView>(R.id.tv_status)
    var statusUpdate = itemView.findViewById<TextView>(R.id.tv_status_update)
    var statusDescription = itemView.findViewById<TextView>(R.id.tv_status_description)
    var shipmentPrice = itemView.findViewById<TextView>(R.id.tv_price)
    var shipmentData = itemView.findViewById<TextView>(R.id.tv_date)
}