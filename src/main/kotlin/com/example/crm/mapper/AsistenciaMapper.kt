package com.example.crm.mapper

import com.example.crm.dto.AsistenciaDto
import com.example.crm.entity.Asistencia
import com.example.crm.entity.Empleado
import java.time.LocalDateTime

/**
 * Mapper para convertir entre `AsistenciaDto` y `Asistencia`, facilitando la transferencia de datos entre la capa de
 * presentación (DTO) y la capa de persistencia (Entidad).
 *
 * Esta clase contiene métodos para convertir una instancia de `AsistenciaDto` a `Asistencia` y viceversa,
 * garantizando la integridad de los datos entre diferentes capas de la aplicación.
 */
object AsistenciaMapper {

    /**
     * Convierte un objeto `AsistenciaDto` en una entidad `Asistencia`.
     *
     * @param asistenciaDto DTO que contiene los datos de la asistencia.
     * @param empleado Entidad `Empleado` asociada a la asistencia, necesaria para establecer la relación.
     * @param tipoAsistencia Tipo de asistencia (por ejemplo, "presencial", "remoto") proporcionado como parámetro
     *                       adicional.
     * @return Una instancia de `Asistencia` con los datos mapeados desde el DTO.
     */
    fun toEntity(asistenciaDto: AsistenciaDto, empleado: Empleado, tipoAsistencia: String): Asistencia {
        return Asistencia(
            empleado = empleado,
            fecha = asistenciaDto.fecha, // Conserva la fecha de asistencia como `LocalDate`.
            horaEntrada = LocalDateTime.of(asistenciaDto.fecha, asistenciaDto.horaEntrada), // Combina fecha y hora de entrada.
            horaSalida = LocalDateTime.of(asistenciaDto.fecha, asistenciaDto.horaSalida), // Combina fecha y hora de salida.
            estado = asistenciaDto.estado,
            tipoAsistencia = tipoAsistencia // Tipo de asistencia pasado como parámetro adicional.
        )
    }

    /**
     * Convierte una entidad `Asistencia` en un objeto `AsistenciaDto`.
     *
     * @param asistencia Entidad `Asistencia` que contiene los datos de la asistencia.
     * @return Una instancia de `AsistenciaDto` con los datos mapeados desde la entidad.
     */
    fun toDto(asistencia: Asistencia): AsistenciaDto {
        return AsistenciaDto(
            empleadoId = asistencia.empleado.empleadoId, // Obtiene el ID del empleado desde la entidad.
            fecha = asistencia.fecha, // Conserva la fecha como `LocalDate`.
            horaEntrada = asistencia.horaEntrada.toLocalTime(), // Extrae solo la hora de entrada.
            horaSalida = asistencia.horaSalida.toLocalTime(), // Extrae solo la hora de salida.
            estado = asistencia.estado,
            tipoAsistencia = asistencia.tipoAsistencia
        )
    }
}
