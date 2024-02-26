package com.hamv.modulo4.fragment.params

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hamv.modulo4.R
import com.hamv.modulo4.databinding.FragmentRecieveParamsBinding
import com.hamv.modulo4.ejercicio2.recyclerautos.Auto


class RecieveParamsFragment : Fragment() {
    private lateinit var binding : FragmentRecieveParamsBinding

    private var name:String? = ""
    private var lastName:String? = ""
    private var carro:Auto?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Aquí obtengo los valores que le pasan al fragment
        arguments?.let {
            name = it.getString("EXTRA_NAME")
            lastName = it.getString("EXTRA_LASTNAME")
            carro =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                    it.getSerializable("EXTRA_AUTO", Auto::class.java);
                }else{
                    it.getSerializable("EXTRA_AUTO") as Auto;
                }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecieveParamsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ctvContentReceiveFragment.text = "Se recibió Name: $name, lastName: $lastName propietario del Auto: ${carro?.marca} ${carro?.modelo} ${carro?.year}"
        //Obtenciòn del contexto desde un fragment
        Toast.makeText(requireContext(), "Se recibió Name: $name, lastName: $lastName propietario del Auto: ${carro?.marca} ${carro?.modelo} ${carro?.year}", Toast.LENGTH_LONG).show()
        binding.btnCallActivity.setOnClickListener {
            val intent = Intent(requireContext(), FinalActivity::class.java).apply {
                putExtra("EXTRA_NAME", "Hugo Meza Vega")
            }
            //Lanzar activity
            startActivity(intent)
        }
    }

    companion object {
        @JvmStatic
        //Aquì declaramos los parametros que esperamos en el fragment
        fun newInstance(name : String, lastName: String, carro:Auto) =
            RecieveParamsFragment().apply {
                arguments = Bundle(). apply {
                    putString("EXTRA_NAME", name)
                    putString("EXTRA_LASTNAME", lastName)
                    putSerializable("EXTRA_AUTO", carro)
                }
            }
    }
}