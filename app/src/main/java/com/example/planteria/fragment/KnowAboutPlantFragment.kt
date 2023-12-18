package com.example.planteria.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.planteria.R
import com.example.planteria.activity.HomeActivity
import com.example.planteria.databinding.FragmentKnowAboutPlantBinding

class KnowAboutPlantFragment : Fragment() {

    lateinit var binding: FragmentKnowAboutPlantBinding
    lateinit var homeActivity: HomeActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKnowAboutPlantBinding.inflate(layoutInflater, container, false)




        return binding.root
    }

    companion object {

        fun newInstance() {

        }
    }
}