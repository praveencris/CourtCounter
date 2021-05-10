package com.example.courtlayout

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.courtlayout.databinding.GameFragmentBinding

const val EXTRA_NAME = "extra_name"

class GameFragment : Fragment() {

    companion object {
        fun newInstance(name: String): Fragment {
            val fragment = GameFragment();
            val args: Bundle = Bundle()
            args.putString(EXTRA_NAME, name)
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var binding: GameFragmentBinding
    private lateinit var viewModel: GameViewModel
    private var name: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("TAG","onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = arguments?.getString(EXTRA_NAME)
        Log.d("TAG","onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("TAG","onCreateView")
        binding = DataBindingUtil.inflate(inflater, R.layout.game_fragment, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TAG","onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("TAG","onActivityCreated")
        viewModel = ViewModelProvider(requireActivity()).get(GameViewModel::class.java)
        // TODO: Use the ViewModel
        val score: Score = Score(0, 0)
        binding.score = score
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.teamAScore.observe(viewLifecycleOwner, Observer { teamAScore ->
            score.teamA = teamAScore.toString()
        })
        viewModel.teamBScore.observe(viewLifecycleOwner, Observer { teamBScore ->
            score.teamB = teamBScore.toString()
        })
        Log.d("TAG",name?:"")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG","onPause")
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG","onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG","onStop")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("TAG","onDetach")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TAG","onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG","onDestroy")
    }

}