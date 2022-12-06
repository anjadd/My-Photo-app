package com.anjad.myphotoapp.utils

sealed interface NetworkState<T> {
    class Loading<T>() : NetworkState<T>
    data class Data<T>(val data: T) : NetworkState<T>
    data class Error<T>(val errorMessage: String? = null, val throwable: Throwable) : NetworkState<T>
}