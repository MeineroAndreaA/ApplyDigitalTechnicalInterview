package com.aam.applydigitaltechnicalinterview.domain

sealed class ApiCallResult<out T : Any> {
    data class Success<out T : Any>(val code: ResultStatus, val data: T) : ApiCallResult<T>()
    data class Error(val code: ResultStatus, val errorMessage: String?) : ApiCallResult<Nothing>()
    data class Exception(val code: ResultStatus, val e: Throwable) : ApiCallResult<Nothing>()
}