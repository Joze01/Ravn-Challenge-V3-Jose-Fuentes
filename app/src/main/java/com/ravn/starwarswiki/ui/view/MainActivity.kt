package com.ravn.starwarswiki.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ravn.starwarswiki.R
import com.ravn.starwarswiki.data.StarwarsRepository
import com.ravn.starwarswiki.databinding.ActivityMainBinding
import com.ravn.starwarswiki.ui.adapter.PersonAdapter
import com.ravn.starwarswiki.ui.viewmodel.PeopleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val peopleViewModel: PeopleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        peopleViewModel.isLoading.observe(this, Observer {
//            binding.loading.isVisible = it
//        })
//        peopleViewModel.luke.observe(this) { name ->
//            binding.luke.text = name
//        }

        peopleViewModel.onCreate()

        initRecyclerView()
//        runBlocking {
//            launch {
////                val swr = StarwarsRepository();
////                swr.getAllPeople()
//            }
//        }
    }

    fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.recyclerStarWars.layoutManager = manager
//        binding.recyclerStarWars.adapter = PersonAdapter()
        binding.recyclerStarWars.addItemDecoration(decoration)
    }
}