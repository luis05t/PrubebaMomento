package com.example.crm.service

import com.example.crm.dto.EmpleadoDto
import com.example.crm.entity.Empleado
import com.example.crm.mapper.EmpleadoMapper
import com.example.crm.repository.EmpleadoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EmpleadoService(private val empleadoRepository: EmpleadoRepository) {

    fun getEmpleados(): List<EmpleadoDto> {
        return empleadoRepository.findAll().map(EmpleadoMapper::toDto)
    }

    @Transactional
    fun save(empleadoDto: EmpleadoDto): EmpleadoDto {
        val empleado = EmpleadoMapper.toEntity(empleadoDto)
        val savedEmpleado = empleadoRepository.save(empleado)
        return EmpleadoMapper.toDto(savedEmpleado)
    }

    fun findById(id: Long): Empleado? {
        return empleadoRepository.findById(id).orElse(null)
    }
}
