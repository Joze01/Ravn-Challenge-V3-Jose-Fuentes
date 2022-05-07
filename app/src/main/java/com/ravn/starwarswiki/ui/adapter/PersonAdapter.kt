package com.ravn.starwarswiki.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.ravn.starwarswiki.R
import com.ravn.starwarswiki.data.model.PersonModel

class PersonAdapter: PagingDataAdapter<PersonModel, PersonViewHolder>(DiffUtilCallback()) {

    private lateinit var itemListenerItem : OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(id:String)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        itemListenerItem = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PersonViewHolder(layoutInflater.inflate(R.layout.item_person, parent, false), itemListenerItem)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val item = getItem(position)!!
        holder.render(item)
    }

//    override fun getItemCount(): Int = peoplePageModel.size

}