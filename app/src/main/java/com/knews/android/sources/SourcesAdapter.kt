package com.knews.android.sources

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.knews.android.R
import com.knews.android.data.Source

/**
 * Created by asafvaron on 02/10/2017.
 */
class SourcesAdapter : RecyclerView.Adapter<SourcesAdapter.SourceItemViewHolder>() {

    var data: List<Source> = emptyList()

    fun setItems(items: List<Source>) {
        this.data = items
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SourceItemViewHolder, position: Int) {
        val source = data[position]
        val context = holder.itemView.context
        holder.sourceName.text = source.name
        holder.sourceDescription.text = source.description
        Glide.with(context)
                .load(source.logo)
                .into(holder.sourceImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceItemViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.source_item, parent, false)
        return SourceItemViewHolder(view)
    }

    inner class SourceItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sourceName: TextView = itemView.findViewById(R.id.source_name)
        val sourceDescription: TextView = itemView.findViewById(R.id.source_description)
        val sourceImage: ImageView = itemView.findViewById(R.id.source_image)
    }
}