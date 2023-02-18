package com.example.pronosticobasket.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.pronosticobasket.databinding.ActivityMainBinding
import com.example.pronosticobasket.ui.recycler.BasketTeamsAdapter
import com.example.pronosticobasket.ui.viewmodel.MainViewModel
import com.google.android.material.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val viewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = BasketTeamsAdapter(emptyList()){ team ->
            initDetailTeam(team.id)
        }
        binding.rvNbaTeams.adapter = adapter
        viewModel.nbaTeams.observe(this) { response ->
            adapter.listTeams = response?.teams ?: emptyList()
            adapter.notifyDataSetChanged()
        }
        viewModel.loading.observe(this){
            binding.pbTeams.isVisible = it
        }
    }

    private fun initDetailTeam(id: Int) {
        val intent = Intent(this,DetailTeamActivity::class.java).apply {
            putExtra(DetailTeamActivity.TEAM_ID,id)
        }
        startActivity(intent)
    }


}