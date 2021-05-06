package com.example.courtlayout

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class Score(private val _teamA: Int, private val _teamB: Int) : BaseObservable() {
    @Bindable
    var teamA: String = _teamA.toString()
        set(value) {
            field = value
            notifyPropertyChanged(BR.teamA)
        }

    @Bindable
    var teamB: String = _teamB.toString()
        set(value) {
            field = value
            notifyPropertyChanged(BR.teamB)
        }

}