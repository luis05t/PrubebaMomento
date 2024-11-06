package com.example.crm.repository

import com.example.crm.entity.Empleado
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repositorio para acceder a los datos de la entidad `Empleado` en la base de datos.
 *
 * Esta interfaz extiende `JpaRepository`, proporcionando acceso a las operaciones CRUD
 * para gestionar los registros de empleados en la base de datos. Spring Data JPA proporciona
 * la implementación de los métodos básicos, sin necesidad de definirlos explícitamente.
 */
@Repository
interface EmpleadoRepository : JpaRepository<Empleado, Long> {
    // Métodos CRUD básicos proporcionados por JpaRepository, como save(), findById(), findAll(), delete(), etc.
}
