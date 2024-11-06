package com.example.crm.repository

import com.example.crm.entity.Asistencia
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AsistenciaRepository : JpaRepository<Asistencia, Long>
