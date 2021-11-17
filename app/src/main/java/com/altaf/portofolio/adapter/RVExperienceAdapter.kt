package com.altaf.portofolio.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.altaf.portofolio.databinding.ItemExperienceBinding
import com.altaf.portofolio.portofolio_modul.Experience
import com.altaf.portofolio.portofolio_modul.Portofolio
import com.altaf.portofolio.R



class RVExperienceAdapter : RecyclerView.Adapter<RVExperienceAdapter.ExperienceViewHolder>(){

    private val listData = ArrayList<Experience>()
    var onItemClicked: ((Experience) -> Unit)? = null

    fun setData(data : List<Experience>?){
        if (data == null) return
        listData.clear()
        listData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder =
        ExperienceViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_experience, parent, false)
        )

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        val listData = listData[position]
        holder.bind(listData)
    }

    override fun getItemCount(): Int = listData.size

    inner class ExperienceViewHolder(view: View) :RecyclerView.ViewHolder(view) {
        private val binding = ItemExperienceBinding.bind(view)

        fun bind(data: Experience) {
           binding.experience = data
            binding.executePendingBindings()
        }

        init {
            binding.root.setOnClickListener {
                onItemClicked?.invoke(listData[adapterPosition])
            }
        }
    }
}