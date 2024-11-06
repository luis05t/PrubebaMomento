package com.example.crm.dto

import java.math.BigDecimal

/**
 * Data transfer object (DTO) que representa la información básica de un empleado.
 *
 * Esta clase se utiliza para transferir datos de los empleados entre el cliente y el servidor.
 *
 * @property nombre Primer nombre del empleado. Se almacena como una cadena de texto.
 * @property apellido Apellido del empleado. Se almacena como una cadena de texto.
 * @property cargo Título o puesto que ocupa el empleado dentro de la organización.
 * @property departamento Departamento al que pertenece el empleado, por ejemplo, "Recursos Humanos" o "TI".
 * @property salario Salario del empleado, expresado en un valor decimal (`BigDecimal`) para manejar valores monetarios precisos.
 *                   Puede ser nulo si no se dispone de esta información.
 * @property fechaContratacion Fecha en la que el empleado fue contratado, representada como una cadena (`String`).
 *                             Se debe utilizar un formato consistente, como "YYYY-MM-DD" (año-mes-día).
 */
data class EmpleadoDto(
    val nombre: String,
    val apellido: String,
    val cargo: String,
    val departamento: String,
    val salario: BigDecimal?, // Puede ser nulo
    val fechaContratacion: String // Debe ser un String que represente la fecha
)
