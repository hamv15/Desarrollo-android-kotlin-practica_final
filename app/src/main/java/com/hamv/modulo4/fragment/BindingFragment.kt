package com.hamv.modulo4.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hamv.modulo4.R
import com.hamv.modulo4.databinding.FragmentBindingBinding

class BindingFragment : Fragment() {
    private lateinit var binding:FragmentBindingBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout a traves de binding
        binding = FragmentBindingBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BindingFragment()
    }
}