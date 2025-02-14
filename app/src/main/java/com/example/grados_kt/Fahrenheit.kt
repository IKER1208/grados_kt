package com.tuapp.conversiongrados

class Fahrenheit(valor: Double) : Grado(valor) {

    override fun convertir(a: Celsius): Double {
        return (valor - 32) * 5 / 9
    }

    override fun convertir(a: Kelvin): Double {
        return (valor - 32) * 5 / 9 + 273.15
    }

    override fun convertir(a: Fahrenheit): Double {
        return valor
    }
}
