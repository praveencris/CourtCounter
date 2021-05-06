package com.example.courtlayout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _teamAScore: MutableLiveData<Int> = MutableLiveData()
    val teamAScore: LiveData<Int> = _teamAScore

    private val _teamBScore: MutableLiveData<Int> = MutableLiveData()
    val teamBScore: LiveData<Int> = _teamBScore

/*
    fun setTeamAScore(score: Int) {
        _teamAScore.value = score
    }*/


    fun plusThreeAClicked(score: Score) {
        _teamAScore.value = score.teamA.toInt() + 3
    }

    fun plusTwoAClicked(score: Score) {
        _teamAScore.value = score.teamA.toInt() + 2
    }

    fun freeThrowAClicked(score: Score) {
        _teamAScore.value = score.teamA.toInt() + 0
    }

    fun plusThreeBClicked(score: Score) {
        _teamBScore.value = score.teamB.toInt() + 3
    }

    fun plusTwoBClicked(score: Score) {
        _teamBScore.value = score.teamB.toInt() + 2
    }

    fun freeThrowBClicked(score: Score) {
        _teamBScore.value = score.teamB.toInt() + 0
    }

    fun resetClicked() {
        _teamAScore.value = 0
        _teamBScore.value = 0
    }


}