package com.example.pronosticobasket.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pronosticobasket.data.model.Game
import com.example.pronosticobasket.databinding.ItemLastGameBinding

class LastGamesAdapter(var listGames: List<Game>, var teamId: Int) :
    RecyclerView.Adapter<LastGamesAdapter.LastGamesHolder>() {
    inner class LastGamesHolder(private val binding: ItemLastGameBinding) :
        ViewHolder(binding.root) {
        fun bind(game: Game) {
            val score1 = game.home_team_score
            val score2 = game.visitor_team_score
            binding.tvTeam1.text = game.home_team.name
            binding.tvTeam2.text = game.visitor_team.name
            binding.tvScoreTeam1.text = score1.toString()
            binding.tvScoreTeam2.text = score2.toString()
            binding.tvResult.text = if (game.home_team.id == teamId) {
                if (score1 > score2) "W" else  "L"
            }else{
                if(score1 > score2) "L" else "W"
            }
            binding.tvDateGame.text = game.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastGamesHolder {
        val binding =
            ItemLastGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LastGamesHolder(binding)
    }

    override fun onBindViewHolder(holder: LastGamesHolder, position: Int) {
        holder.bind(listGames[position])
    }

    override fun getItemCount(): Int = listGames.size
}