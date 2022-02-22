package com.example.spacedrepetition.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spacedrepetition.R
import com.example.spacedrepetition.data.Sets
import kotlinx.android.synthetic.main.recycler_sets.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var setsList = emptyList<Sets>()

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_sets,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return setsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = setsList[position]

        holder.itemView.setIdView.text = currentItem.id.toString()
        holder.itemView.setTitleView.text = currentItem.title
        holder.itemView.setDescriptionView.text = currentItem.setDetails

    }

    fun setData(sets: List<Sets>){
        this.setsList = sets
        notifyDataSetChanged()
    }

   /* fun setData(sets: List<Sets>){
        this.setsList = sets
        notifyDataSetChanged()
    }*/
}