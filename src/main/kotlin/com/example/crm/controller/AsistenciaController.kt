package com.example.crm.controller

import com.example.crm.JSendResponse.JSendResponse
import com.example.crm.dto.AsistenciaDto
import com.example.crm.entity.Empleado
import com.example.crm.service.AsistenciaService
import com.example.crm.service.EmpleadoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/asistencias")
class AsistenciaController(
    private val asistenciaService: AsistenciaService,
    private val empleadoService: EmpleadoService // Inyectamos el servicio de empleados
) {

    /**
     * Obtiene todas las asistencias registradas en el sistema.
     *
     * @return ResponseEntity con el estado y los datos de las asistencias.
     */
    @GetMapping
    fun getAsistencias(): ResponseEntity<Map<String, Any>> {
        val data = asistenciaService.getAsistencias()
        return ResponseEntity.ok(mapOf("status" to "success", "data" to data))
    }

    /**
     * Guarda una nueva asistencia para un empleado. Si el empleado no existe, devuelve un error.
     *
     * @param asistenciaDto objeto que contiene los datos de la asistencia a guardar.
     * @return ResponseEntity con el resultado de la operación (éxito o error).
     */
    @PostMapping
    fun saveAsistencia(
        @Validated @RequestBody asistenciaDto: AsistenciaDto
    ): ResponseEntity<out JSendResponse<out AsistenciaDto>> {
        val empleado: Empleado? = empleadoService.findById(asistenciaDto.empleadoId)

        return if (empleado != null) {
            val savedAsistencia = asistenciaService.save(asistenciaDto, empleado, asistenciaDto.tipoAsistencia)
            ResponseEntity.status(HttpStatus.CREATED)
                .body(JSendResponse.success(savedAsistencia))
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(JSendResponse.error("Empleado no encontrado"))
        }
    }
}
