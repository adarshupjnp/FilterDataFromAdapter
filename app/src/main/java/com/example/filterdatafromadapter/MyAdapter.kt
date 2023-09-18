package com.example.filterdatafromadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val dataList: List<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private val filteredData = ArrayList(dataList)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = filteredData[position]
        holder.textViewItem.text = item
    }

    override fun getItemCount(): Int {
        return filteredData.size
    }

    fun filter(query: String) {
        filteredData.clear()
        if (query.isEmpty()) {
            filteredData.addAll(dataList)
        } else {
            val filteredList = dataList.filter { it.contains(query, ignoreCase = true) }
            filteredData.addAll(filteredList)
        }
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewItem: TextView = itemView.findViewById(R.id.textViewItem)
    }
}

