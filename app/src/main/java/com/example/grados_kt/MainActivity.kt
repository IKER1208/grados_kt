package com.tuapp.conversiongrados

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.grados_kt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConvertir.setOnClickListener {
            val valor = binding.etValor.text.toString().toDoubleOrNull()

            if (valor != null) {
                val grado = Celsius(valor)
                val resultadoF = grado.convertir(Fahrenheit(0.0))
                val resultadoK = grado.convertir(Kelvin(0.0))

                binding.tvResultado.text = "Fahrenheit: $resultadoF\nKelvin: $resultadoK"
            } else {
                binding.tvResultado.text = "Ingresa un valor válido"
            }
        }
    }
}
