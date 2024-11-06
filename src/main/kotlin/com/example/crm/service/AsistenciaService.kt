package com.example.crm.service

import com.example.crm.dto.AsistenciaDto
import com.example.crm.entity.Empleado
import com.example.crm.mapper.AsistenciaMapper
import com.example.crm.repository.AsistenciaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AsistenciaService(private val asistenciaRepository: AsistenciaRepository) {
    fun getAsistencias(): List<AsistenciaDto> {
        return asistenciaRepository.findAll().map(AsistenciaMapper::toDto)
    }

    @Transactional
    fun save(asistenciaDto: AsistenciaDto, empleado: Empleado, tipoAsistencia: String): AsistenciaDto {
        val asistencia = AsistenciaMapper.toEntity(asistenciaDto, empleado, tipoAsistencia) // Ahora incluye tipoAsistencia
        return AsistenciaMapper.toDto(asistenciaRepository.save(asistencia))
    }
}
