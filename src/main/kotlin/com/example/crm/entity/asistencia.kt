package com.example.crm.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * Entidad que representa un registro de asistencia en el sistema.
 *
 * Esta clase mapea la tabla "asistencias" en la base de datos, donde se almacenan los datos de asistencia
 * para cada empleado.
 *
 * @property id Identificador único de la asistencia, generado automáticamente.
 * @property empleado Referencia al empleado asociado a esta asistencia.
 *                    Define una relación muchos-a-uno con la entidad `Empleado`.
 * @property fecha Fecha de la asistencia en formato `LocalDate`, almacenando solo la parte de la fecha (año, mes, día).
 * @property horaEntrada Fecha y hora en la que el empleado registró su entrada, almacenada como `LocalDateTime`
 *                       para incluir tanto la fecha como la hora.
 * @property horaSalida Fecha y hora en la que el empleado registró su salida, almacenada como `LocalDateTime`.
 * @property estado Estado actual de la asistencia, como "presente", "ausente", etc. Este campo no puede ser nulo.
 * @property tipoAsistencia Tipo de asistencia registrada, como "normal", "extraordinaria", "remota", entre otros.
 *                          Este campo es obligatorio y no puede ser nulo.
 */
@Entity
@Table(name = "asistencias")
data class Asistencia(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "empleado_id", nullable = false)
    val empleado: Empleado,

    val fecha: LocalDate, // Mantiene solo la fecha (sin hora)

    @Column(name = "hora_entrada", nullable = false)
    val horaEntrada: LocalDateTime, // Incluye tanto fecha como hora para la entrada

    @Column(name = "hora_salida", nullable = false)
    val horaSalida: LocalDateTime, // Incluye tanto fecha como hora para la salida

    @Column(nullable = false)
    val estado: String,

    @Column(name = "tipo_asistencia", nullable = false)
    val tipoAsistencia: String
)
