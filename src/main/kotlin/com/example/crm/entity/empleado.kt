package com.example.crm.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

/**
 * Entidad que representa un empleado en el sistema.
 *
 * Esta clase mapea la tabla "empleados" en la base de datos, donde se almacenan los datos personales
 * y laborales de cada empleado.
 *
 * @property empleadoId Identificador único del empleado, generado automáticamente por la base de datos.
 * @property nombre Primer nombre del empleado. Este campo es obligatorio y no puede ser nulo.
 * @property apellido Apellido del empleado. Este campo es obligatorio y no puede ser nulo.
 * @property cargo Puesto o título que ocupa el empleado en la organización, por ejemplo, "Gerente" o "Analista".
 *                 Este campo es obligatorio.
 * @property departamento Departamento al que pertenece el empleado, como "Recursos Humanos" o "Tecnología".
 *                        Este campo es obligatorio.
 * @property salario Salario del empleado, almacenado como un valor decimal (`BigDecimal`) para garantizar precisión.
 *                   Este campo es obligatorio y no puede ser nulo.
 * @property fechaContratacion Fecha en la que el empleado fue contratado, almacenada en formato `LocalDate`.
 *                             Es un campo obligatorio y se representa solo la fecha sin incluir la hora.
 */
@Entity
@Table(name = "empleados")
data class Empleado(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val empleadoId: Long = 0,

    @Column(nullable = false)
    val nombre: String,

    @Column(nullable = false)
    val apellido: String,

    @Column(nullable = false)
    val cargo: String,

    @Column(nullable = false)
    val departamento: String,

    @Column(nullable = false)
    val salario: BigDecimal,

    @Column(name = "fecha_contratacion", nullable = false)
    val fechaContratacion: LocalDate
)
