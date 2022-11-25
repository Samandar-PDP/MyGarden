package com.example.sharedelement.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sharedelement.fragment.MyGardenFragment
import com.example.sharedelement.fragment.PlantListFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MyGardenFragment()
            1 -> PlantListFragment()
            else -> Fragment()
        }
    }
}