package com.hamv.modulo4.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hamv.modulo4.R
import com.hamv.modulo4.databinding.FragmentBindinf2Binding

class Bindinf2Fragment : Fragment(R.layout.fragment_bindinf2) {
    //Otra forma de utilizar el binding
    private lateinit var binding : FragmentBindinf2Binding

    //Utilizando otro mètodo de los Fragments
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBindinf2Binding.bind(view)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            Bindinf2Fragment()
    }
}