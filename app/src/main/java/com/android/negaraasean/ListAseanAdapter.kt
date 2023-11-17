package com.android.negaraasean

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAseanAdapter(private val listAsean: ArrayList<Asean>) : RecyclerView.Adapter<ListAseanAdapter.ListViewHolder>() {
    var onItemClick: ((Asean)-> Unit)? = null
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_asean, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int  = listAsean.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val asean = listAsean[position]
        holder.imgPhoto.setImageResource(asean.photo)
        holder.tvName.text = asean.name
        holder.tvDescription.text = asean.description
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(asean)
        }
    }
}