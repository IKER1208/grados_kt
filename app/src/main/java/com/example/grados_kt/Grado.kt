package com.tuapp.conversiongrados

open class Grado(var valor: Double) {

    open fun convertir(a: Celsius): Double {
        return valor
    }

    open fun convertir(a: Kelvin): Double {
        return valor
    }

    open fun convertir(a: Fahrenheit): Double {
        return valor
    }
}
