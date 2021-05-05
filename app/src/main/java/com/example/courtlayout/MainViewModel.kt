package com.example.courtlayout

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _teamAScore: MutableLiveData<Int> = MutableLiveData()
    val teamAScore: LiveData<Int> = _teamAScore
/*
    private val _teamBScore: MutableLiveData<Int> = MutableLiveData()
    val teamBScore: LiveData<Int> = _teamBScore*/


    fun setTeamAScore(score:Int){
        _teamAScore.value=score
    }












    fun plusThreeAClicked() {

    }

    fun plusTwoAClicked() {

    }

    fun freeThrowAClicked() {

    }

    fun plusThreeBClicked() {

    }

    fun plusTwoBClicked() {

    }

    fun freeThrowBClicked() {

    }

    fun resetClicked() {

    }


}