package com.hamv.modulo4.practicafinal

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.hamv.modulo4.R
import com.hamv.modulo4.databinding.FragmentCreateAccountBinding
import com.hamv.modulo4.ejercicio2.recyclerautos.Auto
import com.hamv.modulo4.fragment.params.FinalActivity
import com.hamv.modulo4.fragment.params.RecieveParamsFragment
import com.hamv.modulo4.tarea.ConfirmaRegistroActivity
import com.hamv.modulo4.tarea.entity.Usuario

class CreateAccountFragment : Fragment() {
    private lateinit var binding: FragmentCreateAccountBinding
    //Generación de objeto para almacennar los datos del registro
    private var usuario = Usuario("","", null, -1, "", "")
    private var idGenero: Int = -1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Mètodo para detectar la selección de género
        binding.generoPersonaRegisto.setOnCheckedChangeListener { group, checkedId ->
            idGenero = when(checkedId){
                R.id.rbGeneroFemenidoRegisto -> 1
                R.id.rbGeneroMasculinoRegisto -> 2
                R.id.rbGeneroNoEspecificaRegisto -> 3
                else -> -1
            }
        }

        //Método para agregar los eventos para los botones
        binding.btnNextRegPer.setOnClickListener {
            //Obtener referencia de los elementos visuales
            val nombrePersona = binding.nombrePersonaRegisto.text.trim()
            val primerApellido = binding.primerApellidoPersonaRegisto.text.trim()
            val segundoApellido = binding.segundoApelidoPersonaRegisto.text.trim()
            val correoElectronico = binding.etCorreoElectronico.text.trim()
            val password = binding.etPassword.text.trim()
            val confirmPassword = binding.etPasswordConfirm.text.trim()

            //Validar que los campos obligatorios se hayan ingresado
            if (nombrePersona.isEmpty() || primerApellido.isEmpty() || idGenero == -1 || correoElectronico.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() ){
                Toast.makeText(requireContext(),
                    getString(R.string.toast_validation_create_account), Toast.LENGTH_SHORT).show()
            }else{
                //Validar que las contraseñas coincidan
                if (password.equals(confirmPassword)){
                    //las contraseñas coinciden, procede a setear propiedades en entidad usuario
                    usuario.nombre= nombrePersona.toString()
                    usuario.primerApellido = primerApellido.toString()
                    usuario.segundoApellido = segundoApellido?.toString()
                    usuario.genero = idGenero
                    usuario.email = correoElectronico.toString()
                    usuario.password = password.toString()

                    //Enviar los datos el usuario a través del Intent
                    val intent = Intent(requireContext(), AuthenticatedHomeActivity::class.java).apply {
                        putExtra("EXTRA_USUARIO", usuario)
                    }
                    //Lanzar activity
                    startActivity(intent)

                }else{
                    //Contraseñas no coinciden
                    Toast.makeText(requireContext(),
                        getString(R.string.toast_pass_dont_match), Toast.LENGTH_LONG).show()
                }

            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = CreateAccountFragment()

    }
}