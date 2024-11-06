package com.example.crm.dto

import java.time.LocalDate
import java.time.LocalTime
data class AsistenciaDto(
    val empleadoId: Long,
    val fecha: LocalDate, // Asegúrate de que sea LocalDate
    val horaEntrada: LocalTime,
    val horaSalida: LocalTime,
    val estado: String,
    val tipoAsistencia: String
)
