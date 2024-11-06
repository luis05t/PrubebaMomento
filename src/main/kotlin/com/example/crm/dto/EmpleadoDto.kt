package com.example.crm.dto

import java.math.BigDecimal

data class EmpleadoDto(
    val nombre: String,
    val apellido: String,
    val cargo: String,
    val departamento: String,
    val salario: BigDecimal?, // Puede ser nulo
    val fechaContratacion: String // Debe ser un String que represente la fecha
)
