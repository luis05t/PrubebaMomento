package com.example.crm.mapper

import com.example.crm.dto.EmpleadoDto
import com.example.crm.entity.Empleado
import java.math.BigDecimal
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object EmpleadoMapper {
    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd") // Ajusta el formato según necesites

    fun toEntity(empleadoDto: EmpleadoDto): Empleado {
        return Empleado(
            nombre = empleadoDto.nombre,
            apellido = empleadoDto.apellido,
            cargo = empleadoDto.cargo,
            departamento = empleadoDto.departamento,
            salario = empleadoDto.salario ?: BigDecimal.ZERO, // Asignar un valor por defecto en caso de ser nulo
            fechaContratacion = LocalDate.parse(empleadoDto.fechaContratacion, dateFormatter) // Parsear la fecha desde String
        )
    }

    fun toDto(empleado: Empleado): EmpleadoDto {
        return EmpleadoDto(
            nombre = empleado.nombre,
            apellido = empleado.apellido,
            cargo = empleado.cargo,
            departamento = empleado.departamento,
            salario = empleado.salario,
            fechaContratacion = empleado.fechaContratacion.format(dateFormatter) // Convertir la fecha a String
        )
    }
}
