package com.example.sharedelement.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sharedelement.R
import com.example.sharedelement.databinding.FragmentDetailBinding
import com.example.sharedelement.model.Plant

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private var plant: Plant? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        plant = arguments?.getParcelable("plant")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailBinding.bind(view)
        initViews()
    }


    private fun initViews() {
        plant?.let { p ->
            binding.imageView.setImageResource(p.icon)
            binding.textName.text = p.name
            binding.textDesc.text = p.description
            binding.textWhenPlanted.text = p.plantedDate
        }
        binding.fabBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.fabShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, plant?.name)
            startActivity(Intent.createChooser(intent, ""))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}