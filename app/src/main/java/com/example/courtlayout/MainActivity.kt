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
        viewModel = ViewModelProvider(this)
            .get(MainViewModel::class.java)
        binding.score = Score(0, 0)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this



        viewModel.teamAScore.observe(this, Observer { score ->
            binding.textView2.text = score.toString()
        })

        viewModel.teamBScore.observe(this, Observer { score ->
            binding.textView4.text = score.toString()
        })

    }
}