package com.example.crm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Clase principal de la aplicación CRM.
 *
 * Esta clase está marcada con la anotación `@SpringBootApplication`, lo que indica que es la clase
 * principal de una aplicación Spring Boot. Al ejecutar esta clase, se inicia el contexto de la aplicación
 * Spring Boot y se configura automáticamente el entorno para que la aplicación esté lista para recibir
 * peticiones HTTP y procesarlas según los componentes configurados (controladores, servicios, etc.).
 */
@SpringBootApplication
class CrmApplication

/**
 * Método principal que inicia la aplicación Spring Boot.
 *
 * @param args Argumentos de línea de comandos (si se pasan al iniciar la aplicación).
 *
 * Llama a la función `runApplication<CrmApplication>(*args)` para iniciar el contexto de la aplicación
 * Spring Boot y ejecutar la aplicación.
 */
fun main(args: Array<String>) {
	runApplication<CrmApplication>(*args)
}
