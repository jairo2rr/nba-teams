package com.example.pronosticobasket.ui.viewmodel

import androidx.lifecycle.*
import com.example.pronosticobasket.data.model.ResponseTeam
import com.example.pronosticobasket.domain.GetAllTeams
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getAllTeams: GetAllTeams,
    state:SavedStateHandle
):ViewModel() {
    private val _nbaTeams = MutableLiveData<ResponseTeam?>()
    val nbaTeams:LiveData<ResponseTeam?> = _nbaTeams

    init {
        //Llamada a la api y recibir los equipos
        viewModelScope.launch {
            _nbaTeams.value = getAllTeams()
        }
    }
}