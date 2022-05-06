package com.ravn.starwarswiki.ui.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ravn.starwarswiki.data.model.PersonModel
import com.ravn.starwarswiki.databinding.ItemPersonBinding

class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemPersonBinding.bind(view)

    fun render(personModel: PersonModel) {
        binding.tvPersonName.text = personModel.name
        binding.tvPersonDetails.text = "${personModel.species} from ${personModel.planet}"
        itemView.setOnClickListener {
            Toast.makeText(
                itemView.context,
                personModel.name,
                Toast.LENGTH_SHORT
            )
        }
    }
}