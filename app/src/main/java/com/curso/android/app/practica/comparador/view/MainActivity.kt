package com.curso.android.app.practica.comparador.view


import android.os.Bundle
import android.app.Activity
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.practica.comparador.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mainViewModel.comparador.observe(this){
            binding.resultText.text = "${it.resultado}"
        }

        binding.compareButton.setOnClickListener{
            var text1 = binding.firstText.editText
            var text2 = binding.secondText.editText

            mainViewModel.compare(text1?.text.toString() ?: "", text2?.text.toString() ?: "")
        }
    }

}

