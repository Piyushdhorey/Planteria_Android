package com.example.planteria.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.planteria.R
import com.example.planteria.activity.HomeActivity
import com.example.planteria.databinding.FragmentCaptureBinding

class CaptureFragment : Fragment() {

    lateinit var binding: FragmentCaptureBinding
    lateinit var homeActivity: HomeActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCaptureBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    companion object {

        fun newInstance(homeScreenActivity: HomeActivity) =
            CaptureFragment().apply {
                arguments = Bundle().apply {
                    homeActivity = homeScreenActivity
                }
            }
    }
}