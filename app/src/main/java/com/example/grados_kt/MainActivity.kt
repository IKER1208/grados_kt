package com.tuapp.conversiongrados

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.grados_kt.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //spinner
        val opciones = listOf("Celsius", "Kelvin", "Fahrenheit")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTipoGrado.adapter = adapter

        binding.btnConvertir.setOnClickListener {
            val valor = binding.etValor.text.toString().toDoubleOrNull()
            val seleccion = binding.spinnerTipoGrado.selectedItem.toString()

            if (valor != null) {
                val resultado = when (seleccion) {
                    "Celsius" -> {
                        val celsius = Celsius(valor)
                        "Fahrenheit: ${celsius.convertir(Fahrenheit(0.0))} \nKelvin: ${celsius.convertir(Kelvin(0.0))}"
                    }
                    "Kelvin" -> {
                        val kelvin = Kelvin(valor)
                        "Celsius: ${kelvin.convertir(Celsius(0.0))} \nFahrenheit: ${kelvin.convertir(Fahrenheit(0.0))}"
                    }
                    "Fahrenheit" -> {
                        val fahrenheit = Fahrenheit(valor)
                        "Celsius: ${fahrenheit.convertir(Celsius(0.0))} \nKelvin: ${fahrenheit.convertir(Kelvin(0.0))}"
                    }
                    else -> "Selección inválida"
                }
                binding.tvResultado.text = resultado
            } else {
                Toast.makeText(this, "Ingrese un valor válido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
