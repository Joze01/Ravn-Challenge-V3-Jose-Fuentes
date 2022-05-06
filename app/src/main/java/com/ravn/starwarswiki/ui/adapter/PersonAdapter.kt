package com.ravn.starwarswiki.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ravn.starwarswiki.R
import com.ravn.starwarswiki.data.model.PersonModel

class PersonAdapter(private val peopleList: List<PersonModel>) :
    RecyclerView.Adapter<PersonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PersonViewHolder(layoutInflater.inflate(R.layout.item_person, parent))
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val item = peopleList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = peopleList.size

}