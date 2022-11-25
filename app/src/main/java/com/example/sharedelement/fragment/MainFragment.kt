package com.example.sharedelement.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.sharedelement.R
import com.example.sharedelement.adapter.ViewPagerAdapter
import com.example.sharedelement.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayout

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        initViews()

    }
    private fun initViews() {
        binding.viewPager.adapter = ViewPagerAdapter(this)
        binding.tabs.addTab(binding.tabs.newTab().setText("My Garden"))
        binding.tabs.addTab(binding.tabs.newTab().setText("Plant List"))

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabs.selectTab(binding.tabs.getTabAt(position))
            }
        })

        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.currentItem = tab?.position!!
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        binding.tabs.getTabAt(0)?.setIcon(R.drawable.ic_baseline_local_florist_24)
        binding.tabs.getTabAt(1)?.setIcon(R.drawable.ic_baseline_grass_24)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}