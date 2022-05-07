package com.ravn.starwarswiki.ui.view

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ravn.starwarswiki.databinding.ActivityMainBinding
import com.ravn.starwarswiki.ui.adapter.PersonAdapter
import com.ravn.starwarswiki.ui.view.util.BounceEdgeEffectFactory
import com.ravn.starwarswiki.ui.viewmodel.PeopleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val peopleViewModel: PeopleViewModel by viewModels()
    private lateinit var personAdapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        personAdapter = PersonAdapter()
        personAdapter.setOnItemClickListener(object : PersonAdapter.OnItemClickListener {
            override fun onItemClick(id: String) {
                peopleViewModel.loadPersonDetails(id)
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }

        })
        peopleViewModel.onCreate()
        initRecyclerView()

        lifecycleScope.launch {
            peopleViewModel.pager.collect {
                personAdapter.submitData(it)
            }
        }


    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.recyclerStarWars.layoutManager = manager
        peopleViewModel.personDetails.observe(this, Observer { personDetails ->
            title = personDetails.name
            binding.tvEyeColor.text = personDetails.eyeColor
            binding.tvHairColor.text = personDetails.hairColor
            binding.tvSkinColor.text = personDetails.skinColor
            binding.tvBirthYear.text = personDetails.birthYear
            binding.lvVehicles.adapter = ArrayAdapter(
                this,
                R.layout.simple_list_item_1,
                personDetails.vehicles!!
            )

            binding.slidingPaneLayout.openPane()

        })

        binding.recyclerStarWars.adapter = personAdapter
        binding.recyclerStarWars.addItemDecoration(decoration)
        binding.recyclerStarWars.edgeEffectFactory = BounceEdgeEffectFactory()
    }

    override fun onSupportNavigateUp(): Boolean {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        binding.slidingPaneLayout.closePane()
        title = "People of Star Wars"
        return true
    }

    override fun onBackPressed() {
        binding.slidingPaneLayout.closePane()
    }

}