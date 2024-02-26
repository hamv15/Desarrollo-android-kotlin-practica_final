package com.hamv.modulo4.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.hamv.modulo4.R
import com.hamv.modulo4.databinding.ActivityBackBinding

class BackActivity : AppCompatActivity() {

    private lateinit var binding:ActivityBackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inicializar el binding
        binding = ActivityBackBinding.inflate(layoutInflater)
        //Ligar el binding con la clase
        setContentView(binding.root)
        //Modificar si aparece la flecha de regresar en el actionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //Programar funcionalidad de la flecha del actionbar


        val user = intent.getStringExtra("EXTRA_USER")
        binding.tvUser.text = user
    }

    //Detecciòn del evento al tocar elementos del actionbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                //Guardar en BD la info

                onBackPressedDispatcher.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}