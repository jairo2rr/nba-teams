package com.example.pronosticobasket.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.pronosticobasket.data.BasketRepository
import com.example.pronosticobasket.data.model.Game
import com.example.pronosticobasket.data.model.Team
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: BasketRepository,
    state: SavedStateHandle
) : ViewModel() {

    private val _team = MutableLiveData<Team>()
    val team: LiveData<Team> = _team

    private val _listGames = MutableLiveData<List<Game>>()
    val listGames:LiveData<List<Game>> = _listGames

    init {
        val id: Int = state["team_id"] ?: 0
        if (id > 0)
            viewModelScope.launch {
                _team.value = repository.getInfoTeam(id)
                _listGames.value = repository.getGameTeam(id)?.games ?: emptyList()
            }
    }
}