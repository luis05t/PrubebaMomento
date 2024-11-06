package com.example.crm.repository

import com.example.crm.entity.Asistencia
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repositorio para acceder a los datos de la entidad `Asistencia` en la base de datos.
 *
 * Este repositorio extiende `JpaRepository`, lo que proporciona automáticamente métodos para realizar
 * operaciones CRUD sobre la tabla `asistencias` sin necesidad de implementarlos manualmente.
 * La interfaz es administrada por Spring Data JPA, lo que permite usar métodos de consulta de manera sencilla
 * para interactuar con los datos relacionados con las asistencias.
 */
@Repository
interface AsistenciaRepository : JpaRepository<Asistencia, Long> {
    // No es necesario agregar métodos adicionales si solo se requieren las operaciones CRUD básicas
}
