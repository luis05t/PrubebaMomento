package com.example.crm.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "asistencias")
data class Asistencia(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "empleado_id", nullable = false)
    val empleado: Empleado,

    val fecha: LocalDate, // Mantener como LocalDate si solo necesitas la fecha

    @Column(name = "hora_entrada", nullable = false) // Añadido para especificar la columna
    val horaEntrada: LocalDateTime, // Cambiado a LocalDateTime para incluir fecha y hora

    @Column(name = "hora_salida", nullable = false) // Añadido para especificar la columna
    val horaSalida: LocalDateTime, // Cambiado a LocalDateTime para incluir fecha y hora

    @Column(nullable = false) // Asegúrate de que esto no sea nulo
    val estado: String,

    @Column(name = "tipo_asistencia", nullable = false) // Añadido el campo tipoAsistencia
    val tipoAsistencia: String // Asegúrate de que este campo se rellene al crear una asistencia
)
