package com.example.courtlayout

import android.os.Bundle
import android.view.View
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
        binding.lifecycleOwner = this

        binding.button.setOnClickListener(View.OnClickListener {
            var score = binding.textView2.text.toString().toInt()
            score += 3
            viewModel.setTeamAScore(score)
        })

        viewModel.teamAScore.observe(this, Observer { score ->
            binding.textView2.text = score.toString()
        })

    }
}