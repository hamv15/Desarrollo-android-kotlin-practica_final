package com.hamv.modulo4.fragment.params

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hamv.modulo4.R
import com.hamv.modulo4.databinding.FragmentSendParamsBinding
import com.hamv.modulo4.ejercicio2.recyclerautos.Auto


class SendParamsFragment : Fragment() {

    private lateinit var binding : FragmentSendParamsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSendParamsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSendParams.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerParams, RecieveParamsFragment.newInstance("Hugo", "Meza", Auto("Ford", "Ecosport", "2018")))
                .addToBackStack("ReceiveParamsFragment")
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SendParamsFragment()
    }
}