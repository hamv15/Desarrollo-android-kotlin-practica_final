package com.hamv.modulo4.binding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hamv.modulo4.R
import com.hamv.modulo4.databinding.ActivityBindingBinding

class BindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inicializa binding
        binding = ActivityBindingBinding.inflate(layoutInflater)
        //Enlace entre vista y clase controlador por medio de binding
        setContentView(binding.root)

        //Modificar si aparece la flecha de regresar en el actionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.title = "Inicio de sesión"

        //Ocultar el titulo
        //supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.tvTitle.text = "Ingresa tu usuario"

        binding.btnSend.setOnClickListener {
            if (binding.etUser.text.isEmpty()){
                Toast.makeText(this, "Debes ingresar datos", Toast.LENGTH_SHORT).show()
            }else{
                //Mandar a llamar el otro activity
                val nextActivity = Intent(this, BackActivity::class.java).apply {
                    putExtra("EXTRA_USER", binding.etUser.text.toString().trim())
                }
                //Inicia el intent para lanzar el siguiente activity
                startActivity(nextActivity)
            }
        }

    }
}