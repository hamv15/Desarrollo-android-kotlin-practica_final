package com.hamv.modulo4.fragment.params

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hamv.modulo4.R
import com.hamv.modulo4.databinding.ActivityParamsBinding

class ParamsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityParamsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inicializaciòn del binding
        binding = ActivityParamsBinding.inflate(layoutInflater)
        //Enlace a través de binding
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerParams, SendParamsFragment.newInstance())
            .commit()
    }
}