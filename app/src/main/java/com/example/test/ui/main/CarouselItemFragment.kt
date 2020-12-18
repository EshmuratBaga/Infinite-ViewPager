package com.example.test.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.test.R
import kotlinx.android.synthetic.main.fragment_screen_slide_page.*

class CarouselItemFragment : Fragment(){
    companion object {
        fun newInstance() = CarouselItemFragment()
    }

    lateinit var url: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_screen_slide_page, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImage(url)
    }

    private fun setImage(url: String) {
        Glide
            .with(requireContext())
            .load(url)
            .centerCrop()
            .into(image);
    }
}