package com.example.crm.mapper

import com.example.crm.dto.AsistenciaDto
import com.example.crm.entity.Asistencia
import com.example.crm.entity.Empleado
import java.time.LocalDateTime

object AsistenciaMapper {

    fun toEntity(asistenciaDto: AsistenciaDto, empleado: Empleado, tipoAsistencia: String): Asistencia {
        return Asistencia(
            empleado = empleado,
            fecha = asistenciaDto.fecha, // Se mantiene como LocalDate
            horaEntrada = LocalDateTime.of(asistenciaDto.fecha, asistenciaDto.horaEntrada), // Combina fecha y hora
            horaSalida = LocalDateTime.of(asistenciaDto.fecha, asistenciaDto.horaSalida), // Combina fecha y hora
            estado = asistenciaDto.estado,
            tipoAsistencia = tipoAsistencia // Asegúrate de pasar este parámetro
        )
    }

    fun toDto(asistencia: Asistencia): AsistenciaDto {
        return AsistenciaDto(
            empleadoId = asistencia.empleado.empleadoId,
            fecha = asistencia.fecha, // Se mantiene como LocalDate
            horaEntrada = asistencia.horaEntrada.toLocalTime(), // Extrae solo la hora
            horaSalida = asistencia.horaSalida.toLocalTime(), // Extrae solo la hora
            estado = asistencia.estado,
            tipoAsistencia = asistencia.tipoAsistencia
        )
    }
}
