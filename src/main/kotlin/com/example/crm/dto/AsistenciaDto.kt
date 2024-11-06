package com.example.crm.dto

import java.time.LocalDate
import java.time.LocalTime

/**
 * Data transfer object (DTO) que representa los detalles de asistencia de un empleado.
 *
 * Esta clase se utiliza para transferir información sobre la asistencia entre el cliente y el servidor.
 *
 * @property empleadoId Identificador único del empleado.
 *                      Se usa para vincular la asistencia con un empleado específico en la base de datos.
 * @property fecha Fecha de la asistencia en formato de calendario (año, mes, día).
 *                 Utiliza `LocalDate` para manejar fechas sin la hora, asegurando que solo se registre la fecha específica.
 * @property horaEntrada Hora en la que el empleado ingresó.
 *                       Utiliza `LocalTime` para registrar únicamente la hora, sin la fecha.
 * @property horaSalida Hora en la que el empleado salió.
 *                      También utiliza `LocalTime` y solo registra la hora de salida, sin la fecha.
 * @property estado Estado actual de la asistencia, que puede indicar si el empleado está "presente", "ausente", etc.
 *                 Esto ayuda a definir si el empleado cumplió con su jornada laboral.
 * @property tipoAsistencia Tipo de asistencia registrada, como "normal", "extraordinaria", "remota", etc.
 *                          Ayuda a categorizar la asistencia y puede tener implicaciones en la gestión de horarios o pago.
 */
data class AsistenciaDto(
    val empleadoId: Long,
    val fecha: LocalDate,
    val horaEntrada: LocalTime,
    val horaSalida: LocalTime,
    val estado: String,
    val tipoAsistencia: String
)
