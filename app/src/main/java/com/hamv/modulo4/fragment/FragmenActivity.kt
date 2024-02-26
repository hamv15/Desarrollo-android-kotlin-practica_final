package com.hamv.modulo4.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hamv.modulo4.R
import com.hamv.modulo4.databinding.ActivityFragmenBinding

class FragmenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inicializamos la variable binding (siempre antes del setContentView)
        binding = ActivityFragmenBinding.inflate(layoutInflater)
        //Le pasamos el root del binding
        setContentView(binding.root)

        //Con este metodo se cargan los framgments al activity por medio de código
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmenContainer2, Bindinf2Fragment.newInstance())
            .commit()



    }
}