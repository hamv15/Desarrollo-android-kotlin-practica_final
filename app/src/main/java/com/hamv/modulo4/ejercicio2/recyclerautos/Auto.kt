package com.hamv.modulo4.ejercicio2.recyclerautos

import java.io.Serializable

data class Auto(
    val marca : String,
    val modelo: String,
    val year: String
): Serializable
