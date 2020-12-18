package com.example.test.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.test.model.DataResponse

class CarouselAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    var data: List<DataResponse> = emptyList()

    override fun getCount(): Int = if (data.isEmpty()) 0 else Int.MAX_VALUE

    override fun getItem(position: Int): Fragment {
        val frag = CarouselItemFragment.newInstance()
        frag.url = data[position(position)].url
        return frag
    }

    fun update(list: List<DataResponse>) {
        data = list
        notifyDataSetChanged()
    }

    private fun position(position: Int) : Int{
        return position % data.size
    }
}
