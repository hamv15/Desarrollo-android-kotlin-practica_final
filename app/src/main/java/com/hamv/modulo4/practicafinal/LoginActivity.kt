package com.hamv.modulo4.practicafinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hamv.modulo4.R
import com.hamv.modulo4.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Se inicializa el bindin
        binding = ActivityLoginBinding.inflate(layoutInflater)
        //Enlace a través de binding
        setContentView(binding.root)

        //Se realiza transacción para los fragments
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerLogin, LoginFragment.newInstance())
            .commit()
    }
}