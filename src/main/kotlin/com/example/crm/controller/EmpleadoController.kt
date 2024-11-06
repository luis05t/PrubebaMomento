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

    /**
     * Obtiene la lista completa de empleados registrados en el sistema.
     *
     * @return ResponseEntity que contiene una lista de `EmpleadoDto` representando todos los empleados.
     * La respuesta tiene un estado HTTP 200 OK.
     */
    @GetMapping
    fun getEmpleados(): ResponseEntity<List<EmpleadoDto>> {
        return ResponseEntity.ok(empleadoService.getEmpleados())
    }

    /**
     * Registra un nuevo empleado en el sistema.
     *
     * @param empleadoDto Objeto que contiene la información del empleado a registrar.
     * Se valida el contenido del objeto antes de guardarlo.
     * @return ResponseEntity que contiene el `EmpleadoDto` del empleado registrado, con un estado HTTP 201 Created.
     */
    @PostMapping
    fun saveEmpleado(@Validated @RequestBody empleadoDto: EmpleadoDto): ResponseEntity<EmpleadoDto> {
        val savedEmpleado = empleadoService.save(empleadoDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmpleado)
    }
}
