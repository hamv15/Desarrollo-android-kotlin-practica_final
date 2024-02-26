package com.hamv.modulo4.practicafinal

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hamv.modulo4.R
import com.hamv.modulo4.databinding.FragmentLoginBinding
import com.hamv.modulo4.ejercicio2.recyclerautos.Auto
import com.hamv.modulo4.fragment.params.RecieveParamsFragment
import com.hamv.modulo4.tarea.entity.Usuario


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    //Generación de objeto para almacennar los datos del registro
    private var usuario = Usuario("Luis Angel","Martínez", "Perez", 2, "spark9556@gmail.com", "Hola123")
    private var email: String = ""
    private var pass: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }


    //Este método lo utilizo para restablecer los campos simulando un cierre de sesión
    override fun onResume() {
        super.onResume()
        //Limpiar los campos?
        binding.emailUser.setText("")
        binding.passwordUser.setText("")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Método para agregar los eventos para los botones
        binding.createAccountButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerLogin, CreateAccountFragment.newInstance())
                .addToBackStack("CreateAccountFragment")
                .commit()
        }

        //Evento para solicitar inicio de sesión
        binding.loginButton.setOnClickListener {
            //Obtener usuario y contraseña
            email = binding.emailUser.text.trim().toString()
            pass = binding.passwordUser.text.toString().trim()

            //Validar que correspondan al usuario guardad
            if (usuario.email.equals(email) && usuario.password.equals(pass)){
                //Generar el intent para mandar los datos del usuario
                val intent = Intent(requireContext(), AuthenticatedHomeActivity::class.java).apply{
                    putExtra("EXTRA_USUARIO", usuario)
                }
                //Lanzar el activity de registro
                startActivity(intent)
            }else{
                Toast.makeText(requireContext(),
                    getString(R.string.toast_bad_credentials), Toast.LENGTH_SHORT).show()
            }

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

}