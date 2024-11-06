package com.example.crm.service

import com.example.crm.dto.EmpleadoDto
import com.example.crm.entity.Empleado
import com.example.crm.mapper.EmpleadoMapper
import com.example.crm.repository.EmpleadoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Servicio encargado de manejar la lógica de negocio relacionada con los empleados.
 *
 * Esta clase proporciona métodos para obtener, guardar y buscar empleados, interactuando con el repositorio
 * `EmpleadoRepository` y utilizando el `EmpleadoMapper` para convertir entre las entidades
 * `Empleado` y los DTOs `EmpleadoDto`.
 */
@Service
class EmpleadoService(private val empleadoRepository: EmpleadoRepository) {

    /**
     * Obtiene todos los empleados registrados en la base de datos.
     *
     * @return Una lista de objetos `EmpleadoDto`, que representan todos los empleados
     * registrados en la base de datos.
     */
    fun getEmpleados(): List<EmpleadoDto> {
        // Se obtienen todos los empleados del repositorio y se convierten a DTOs
        return empleadoRepository.findAll().map(EmpleadoMapper::toDto)
    }

    /**
     * Guarda un nuevo empleado en la base de datos.
     *
     * @param empleadoDto Los datos del empleado a guardar.
     * @return Un objeto `EmpleadoDto` con los datos del empleado recién guardado.
     */
    @Transactional
    fun save(empleadoDto: EmpleadoDto): EmpleadoDto {
        // Se convierte el DTO en una entidad y se guarda en la base de datos
        val empleado = EmpleadoMapper.toEntity(empleadoDto)
        val savedEmpleado = empleadoRepository.save(empleado)
        // Se convierte la entidad guardada en un DTO y se retorna
        return EmpleadoMapper.toDto(savedEmpleado)
    }

    /**
     * Busca un empleado por su ID en la base de datos.
     *
     * @param id El ID del empleado a buscar.
     * @return Un objeto `Empleado` si se encuentra el empleado con el ID dado, o null si no se encuentra.
     */
    fun findById(id: Long): Empleado? {
        // Busca el empleado por su ID y lo retorna si existe, o null si no se encuentra
        return empleadoRepository.findById(id).orElse(null)
    }
}
