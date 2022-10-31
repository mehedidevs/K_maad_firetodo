package com.es.k_maad_firetodo.utils

sealed class UiState<T>(val data: T? = null, val message: String? = null) {

    class Loading<T>() : UiState<T>()
    class Success<T>(data: T) : UiState<T>(data)
    class Failure<T>(data: T? = null, message: String) : UiState<T>(data, message)

}
