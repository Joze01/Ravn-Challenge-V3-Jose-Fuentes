package com.ravn.starwarswiki.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ravn.starwarswiki.data.model.PersonModel

class DiffUtilCallback : DiffUtil.ItemCallback<PersonModel>() {
    override fun areItemsTheSame(oldItem: PersonModel, newItem: PersonModel): Boolean {
        return oldItem.name == newItem.name

    }

    override fun areContentsTheSame(oldItem: PersonModel, newItem: PersonModel): Boolean {
        return oldItem.name == newItem.name
    }

}