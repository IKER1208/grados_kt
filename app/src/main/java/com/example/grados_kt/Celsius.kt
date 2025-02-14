package com.tuapp.conversiongrados

class Celsius(valor: Double) : Grado(valor) {

    override fun convertir(a: Celsius): Double {
        return valor
    }

    override fun convertir(a: Kelvin): Double {
        return valor + 273.15
    }

    override fun convertir(a: Fahrenheit): Double {
        return (valor * 9 / 5) + 32
    }
}
