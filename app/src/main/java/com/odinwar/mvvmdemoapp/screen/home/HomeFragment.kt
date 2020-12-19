package com.odinwar.mvvmdemoapp.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.odinwar.mvvmdemoapp.R

class HomeFragment private constructor() : Fragment() {
    private val homViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homViewModel.dataMovie.observe(viewLifecycleOwner) {}
        homViewModel.loadError.observe(viewLifecycleOwner) { item ->
            Toast.makeText(context, item.toString(), Toast.LENGTH_SHORT).show()
        }
        homViewModel.loadData()
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
