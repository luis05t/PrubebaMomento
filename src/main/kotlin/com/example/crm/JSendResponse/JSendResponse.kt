package com.example.crm.JSendResponse

/**
 * Clase de respuesta que sigue el estándar JSend para estructurar las respuestas de la API.
 *
 * El estándar JSend organiza las respuestas en tres posibles estados:
 * - "success": La solicitud se procesó correctamente y contiene datos en el campo `data`.
 * - "error": La solicitud falló y contiene un mensaje de error en el campo `message`.
 *
 * @param status Indica el estado de la respuesta, ya sea "success" o "error".
 * @param data Contiene los datos en caso de una respuesta exitosa. Puede ser nulo si no se requiere.
 * @param message Contiene un mensaje descriptivo en caso de error. Puede ser nulo en respuestas exitosas.
 */
data class JSendResponse<T>(
    val status: String,
    val data: T? = null,
    val message: String? = null
) {
    companion object {
        /**
         * Método auxiliar para crear una respuesta exitosa con el estado "success".
         *
         * @param data Los datos que se devolverán en la respuesta. Estos se incluirán en el campo `data`.
         * @return Una instancia de `JSendResponse` con el estado "success" y los datos proporcionados.
         */
        fun <T> success(data: T): JSendResponse<T> {
            return JSendResponse(status = "success", data = data)
        }

        /**
         * Método auxiliar para crear una respuesta de error con el estado "error".
         *
         * @param message Mensaje que describe el motivo del error, el cual se incluirá en el campo `message`.
         * @return Una instancia de `JSendResponse` con el estado "error" y el mensaje de error proporcionado.
         */
        fun error(message: String): JSendResponse<Nothing> {
            return JSendResponse(status = "error", message = message)
        }
    }
}
