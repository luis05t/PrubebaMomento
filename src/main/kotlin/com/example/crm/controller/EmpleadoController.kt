package com.example.crm.controller

import com.example.crm.dto.EmpleadoDto
import com.example.crm.service.EmpleadoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/empleados")
class EmpleadoController(private val empleadoService: EmpleadoService) {
    @GetMapping
    fun getEmpleados(): ResponseEntity<List<EmpleadoDto>> {
        return ResponseEntity.ok(empleadoService.getEmpleados())
    }

    @PostMapping
    fun saveEmpleado(@Validated @RequestBody empleadoDto: EmpleadoDto): ResponseEntity<EmpleadoDto> {
        val savedEmpleado = empleadoService.save(empleadoDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmpleado)
    }
}
