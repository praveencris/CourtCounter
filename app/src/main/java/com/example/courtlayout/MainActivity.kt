package com.example.courtlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.courtlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))
            .get(MainViewModel::class.java)
        binding.viewModel = viewModel
        val score: Score = Score(0, 0)
        binding.score = score
        binding.lifecycleOwner = this


        viewModel.teamAScore.observe(this, Observer { it ->
            score.teamA = it.toString()
        })

        viewModel.teamBScore.observe(this, Observer { it ->
            score.teamB = it.toString()
        })
    }
}