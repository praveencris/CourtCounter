package com.example.courtlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.courtlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val fragmentManager=supportFragmentManager;
        val name:String="Game Data";
        val fragment= fragmentManager.findFragmentById(R.id.container)
        if(fragment==null){
            fragmentManager.beginTransaction()
                .add(R.id.container,GameFragment.newInstance(name))
                .commit();
        }else{
            fragmentManager.beginTransaction()
                .replace(R.id.container,GameFragment.newInstance(name))
                .commit();
        }

    }
}