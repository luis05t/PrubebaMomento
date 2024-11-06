package com.example.crm.JSendResponse

data class JSendResponse<T>(
    val status: String,
    val data: T? = null,
    val message: String? = null
) {
    companion object {
        fun <T> success(data: T): JSendResponse<T> {
            return JSendResponse(status = "success", data = data)
        }

        fun error(message: String): JSendResponse<Nothing> {
            return JSendResponse(status = "error", message = message)
        }
    }
}
