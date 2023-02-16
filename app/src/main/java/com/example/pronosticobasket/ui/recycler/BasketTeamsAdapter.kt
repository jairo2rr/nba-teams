package com.example.pronosticobasket.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pronosticobasket.data.model.Team
import com.example.pronosticobasket.databinding.ItemTeamBinding

class BasketTeamsAdapter(var listTeams:List<Team>, val onTeamClick:(Team)->Unit):RecyclerView.Adapter<BasketTeamsAdapter.BasketTeamHolder>(){
    inner class BasketTeamHolder(private val binding: ItemTeamBinding):ViewHolder(binding.root){
        fun bind(team: Team){
            binding.tvTeamName.text = team.name
            binding.tvTeamCountry.text = team.city
            binding.tvTeamAbbreviation.text = team.abbreviation
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketTeamHolder {
        val binding = ItemTeamBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BasketTeamHolder(binding)
    }

    override fun onBindViewHolder(holder: BasketTeamHolder, position: Int) {
        holder.bind(listTeams[position])
        holder.itemView.setOnClickListener { onTeamClick(listTeams[position]) }
    }

    override fun getItemCount(): Int = listTeams.size
}