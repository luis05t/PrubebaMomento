package com.example.crm.service

import com.example.crm.dto.AsistenciaDto
import com.example.crm.entity.Empleado
import com.example.crm.mapper.AsistenciaMapper
import com.example.crm.repository.AsistenciaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Servicio encargado de manejar la lógica de negocio relacionada con las asistencias.
 *
 * Esta clase proporciona métodos para obtener y guardar asistencias, interactuando con el repositorio
 * `AsistenciaRepository` y utilizando el `AsistenciaMapper` para convertir entre las entidades
 * `Asistencia` y los DTOs `AsistenciaDto`.
 */
@Service
class AsistenciaService(private val asistenciaRepository: AsistenciaRepository) {

    /**
     * Obtiene todas las asistencias registradas en la base de datos.
     *
     * @return Una lista de objetos `AsistenciaDto`, que representan todas las asistencias
     * registradas en la base de datos.
     */
    fun getAsistencias(): List<AsistenciaDto> {
        // Se obtienen todas las asistencias del repositorio y se convierten a DTOs
        return asistenciaRepository.findAll().map(AsistenciaMapper::toDto)
    }

    /**
     * Guarda una nueva asistencia en la base de datos.
     *
     * @param asistenciaDto Los datos de la asistencia a guardar.
     * @param empleado El empleado que realiza la asistencia.
     * @param tipoAsistencia El tipo de asistencia (por ejemplo, 'presente', 'ausente').
     * @return Un objeto `AsistenciaDto` con los datos de la asistencia recién guardada.
     */
    @Transactional
    fun save(asistenciaDto: AsistenciaDto, empleado: Empleado, tipoAsistencia: String): AsistenciaDto {
        // Se convierte el DTO en una entidad y se guarda en la base de datos
        val asistencia = AsistenciaMapper.toEntity(asistenciaDto, empleado, tipoAsistencia)
        // Se guarda la asistencia y se convierte la entidad guardada en un DTO
        return AsistenciaMapper.toDto(asistenciaRepository.save(asistencia))
    }
}
