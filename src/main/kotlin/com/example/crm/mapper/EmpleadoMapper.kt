package com.example.crm.mapper

import com.example.crm.dto.EmpleadoDto
import com.example.crm.entity.Empleado
import java.math.BigDecimal
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Mapper para convertir entre `EmpleadoDto` y `Empleado`, facilitando la transferencia de datos entre la capa de
 * presentación (DTO) y la capa de persistencia (Entidad).
 *
 * Esta clase contiene métodos para convertir una instancia de `EmpleadoDto` a `Empleado` y viceversa,
 * asegurando que la información se transfiera adecuadamente entre las diferentes capas de la aplicación.
 */
object EmpleadoMapper {
    // Formato para parsear y formatear las fechas
    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd") // Ajusta el formato según necesites

    /**
     * Convierte un objeto `EmpleadoDto` en una entidad `Empleado`.
     *
     * @param empleadoDto DTO que contiene los datos del empleado.
     * @return Una instancia de `Empleado` con los datos mapeados desde el DTO.
     */
    fun toEntity(empleadoDto: EmpleadoDto): Empleado {
        return Empleado(
            nombre = empleadoDto.nombre,
            apellido = empleadoDto.apellido,
            cargo = empleadoDto.cargo,
            departamento = empleadoDto.departamento,
            salario = empleadoDto.salario ?: BigDecimal.ZERO, // Si el salario es nulo, se asigna BigDecimal.ZERO como valor por defecto
            // Parsear la fecha desde String a LocalDate usando el formato especificado
            fechaContratacion = LocalDate.parse(empleadoDto.fechaContratacion, dateFormatter)
        )
    }

    /**
     * Convierte una entidad `Empleado` en un objeto `EmpleadoDto`.
     *
     * @param empleado Entidad `Empleado` que contiene los datos del empleado.
     * @return Una instancia de `EmpleadoDto` con los datos mapeados desde la entidad.
     */
    fun toDto(empleado: Empleado): EmpleadoDto {
        return EmpleadoDto(
            nombre = empleado.nombre,
            apellido = empleado.apellido,
            cargo = empleado.cargo,
            departamento = empleado.departamento,
            salario = empleado.salario,
            // Convertir la fecha de LocalDate a String usando el formato especificado
            fechaContratacion = empleado.fechaContratacion.format(dateFormatter)
        )
    }
}
