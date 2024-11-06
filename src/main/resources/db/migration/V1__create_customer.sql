-- Tabla de Empleados
CREATE TABLE empleados (
                           empleado_id SERIAL PRIMARY KEY,
                           nombre VARCHAR(100) NOT NULL,
                           apellido VARCHAR(100) NOT NULL,
                           cargo VARCHAR(100) NOT NULL,
                           departamento VARCHAR(100) NOT NULL,
                           salario DECIMAL(10, 2) NOT NULL,
                           fecha_contratacion DATE NOT NULL
);

-- Tabla de Asistencia
CREATE TABLE asistencias (
                            id SERIAL PRIMARY KEY,
                            empleado_id INTEGER NOT NULL,
                            fecha DATE NOT NULL,
                            hora_entrada TIME NOT NULL,
                            hora_salida TIME NOT NULL,
                            estado VARCHAR(20) NOT NULL,
                            tipo_asistencia VARCHAR(20) NOT NULL,  -- Tipo de asistencia (ej. Regular, Tardía, Ausente)
                            FOREIGN KEY (empleado_id) REFERENCES empleados(empleado_id) ON DELETE CASCADE,
                            CHECK (hora_salida > hora_entrada)  -- Asegura que hora_salida sea mayor que hora_entrada
);
