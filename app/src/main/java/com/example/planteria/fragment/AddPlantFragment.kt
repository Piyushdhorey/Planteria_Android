package com.example.planteria.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.planteria.R
import com.example.planteria.activity.HomeActivity
import com.example.planteria.databinding.FragmentAddPlantBinding

class AddPlantFragment : Fragment() {

    lateinit var binding: FragmentAddPlantBinding
    lateinit var homeActivity: HomeActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddPlantBinding.inflate(layoutInflater, container, false)


        return binding.root
    }

    companion object {
        fun newInstance() =
            AddPlantFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}