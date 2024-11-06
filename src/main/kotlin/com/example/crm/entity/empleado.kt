package com.example.crm.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

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
