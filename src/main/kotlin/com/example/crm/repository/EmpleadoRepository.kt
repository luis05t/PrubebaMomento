package com.example.crm.repository

import com.example.crm.entity.Empleado
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmpleadoRepository : JpaRepository<Empleado, Long>
