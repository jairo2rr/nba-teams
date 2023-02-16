package com.example.pronosticobasket.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.pronosticobasket.data.model.Team
import com.example.pronosticobasket.databinding.ActivityDetailTeamBinding
import com.example.pronosticobasket.ui.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailTeamActivity : AppCompatActivity() {
    companion object{
        const val TEAM_ID = "team_id"
    }
    private var teamId:Int? = null
    private lateinit var binding:ActivityDetailTeamBinding
    private val detailViewModel:DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        teamId = intent.getIntExtra(TEAM_ID,0)

        detailViewModel.team.observe(this){
            fillCardTeam(it)
        }

    }

    private fun fillCardTeam(team: Team){
        binding.tvTeamNameTitle.text = team.name
        binding.tvCity.text = team.city
        binding.tvAbbreviation.text = team.abbreviation
        binding.tvDivision.text = team.division
        binding.tvConference.text = team.conference
        binding.tvFullTeamName.text = team.full_name
    }
}