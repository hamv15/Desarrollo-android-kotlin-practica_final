package com.hamv.modulo4.fragment.params

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hamv.modulo4.R
import com.hamv.modulo4.databinding.ActivityFinalBinding
import com.hamv.modulo4.databinding.ActivityParamsBinding
import com.hamv.modulo4.intent.Auto

class FinalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinalBinding

    private var name:String = ""
    private var lastname:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("EXTRA_NAME")){
            name=intent.getStringExtra("EXTRA_NAME") ?: ""
        }
        binding.tvContent.text = name
        val lastName = intent.getStringExtra("EXTRA_LASTNAME")
        val carro =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                intent.getSerializableExtra("EXTRA_AUTO", Auto::class.java);
            }else{
                intent.getSerializableExtra("EXTRA_AUTO") as Auto;
            }
    }
}