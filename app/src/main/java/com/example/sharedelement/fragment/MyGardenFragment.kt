package com.example.sharedelement.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sharedelement.R
import com.example.sharedelement.adapter.PlantAdapter
import com.example.sharedelement.databinding.FragmentMyGardenBinding
import com.example.sharedelement.util.Constants

class MyGardenFragment : Fragment(R.layout.fragment_my_garden) {

    private var _binding: FragmentMyGardenBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMyGardenBinding.bind(view)

        initViews()
    }

    private fun initViews() {
        val plantAdapter = PlantAdapter()
        binding.rv.adapter = plantAdapter
        plantAdapter.submitList(Constants.plantList())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}