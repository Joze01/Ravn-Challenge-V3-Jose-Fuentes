package com.ravn.starwarswiki.ui.adapter

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ravn.starwarswiki.data.model.PersonModel
import com.ravn.starwarswiki.databinding.ItemPersonBinding

class PersonViewHolder(view: View, listener: PersonAdapter.OnItemClickListener) : RecyclerView.ViewHolder(view) {
    private val binding = ItemPersonBinding.bind(view)
    private val listener = listener

    fun render(personModel: PersonModel) {
        binding.tvPersonName.text = personModel.name
        binding.tvPersonDetails.text = "${personModel.species} from ${personModel.planet}"
        itemView.setOnClickListener {
            personModel.id?.let { it1 -> listener.onItemClick(it1) }

            Log.d("click!!!", "hizo clik coño ${personModel.name} de la especie ${personModel.species}")
            Toast.makeText(
                itemView.context,
                personModel.name,
                Toast.LENGTH_LONG
            ).show()

        }
    }
}