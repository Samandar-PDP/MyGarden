package com.example.sharedelement.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sharedelement.R
import com.example.sharedelement.adapter.PlantAdapter
import com.example.sharedelement.databinding.FragmentPlantListBinding
import com.example.sharedelement.util.Constants

class PlantListFragment : Fragment(R.layout.fragment_plant_list) {

    private var _binding: FragmentPlantListBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPlantListBinding.bind(view)

        initViews()
    }

    private fun initViews() {
        val plantAdapter = PlantAdapter()
        binding.rv.adapter = plantAdapter
        plantAdapter.submitList(Constants.plantList())
        plantAdapter.onClick = {
            val bundle = bundleOf("plant" to it)
            findNavController().navigate(R.id.action_mainFragment_to_detailFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}