package com.hamv.modulo4.practicafinal

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import com.hamv.modulo4.R
import com.hamv.modulo4.databinding.ActivityAuthenticatedHomeBinding
import com.hamv.modulo4.tarea.entity.Usuario

class AuthenticatedHomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAuthenticatedHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticatedHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var genero: String = ""

        //Verificar y extraer los datos del usuario
        if (intent.hasExtra("EXTRA_USUARIO")){
            //Obtengo el dato del usuario
            val persona =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                    intent.getSerializableExtra("EXTRA_USUARIO", Usuario::class.java);
                }else{
                    intent.getSerializableExtra("EXTRA_USUARIO") as Usuario;
                }
            //Obtención del género a través del id
            if (persona?.genero == 1){
                genero="Femenino"
            }else if (persona?.genero == 2){
                genero="Masculino"
            }else if (persona?.genero == 3){
                genero="No especificado"
            }else{
                genero="Desconocido"
            }

            //Mostrar datos de inicio de sesión
            binding.contenidoRegistrado.text = "Se ha registrado a ${persona?.nombre} ${persona?.primerApellido} ${persona?.segundoApellido ?: ""} especificando el género: ${genero} y correo electrónico: ${persona?.email}"

        }else{
            Toast.makeText(this, "No se obtuvieron los datos correctamente", Toast.LENGTH_SHORT).show()
        }

    }

}