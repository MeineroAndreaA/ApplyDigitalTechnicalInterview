package com.aam.applydigitaltechnicalinterview.domain.remote

import retrofit2.HttpException
import retrofit2.Response

interface RemoteRepository {

    suspend fun <T : Any> handleApi(execute: suspend () -> Response<T>): ApiCallResult<T> {
        try {
            val response = execute()
            return if (response.isSuccessful) {
                ApiCallResult.Success(ResultStatus.SUCCESS, response.body()!!)
            } else {
                ApiCallResult.Error(ResultStatus.ERROR, response.errorBody()?.toString())
            }
        } catch (e: HttpException) {
            return ApiCallResult.Error(ResultStatus.ERROR, e.message())
        } catch (e: Throwable) {
            return ApiCallResult.Exception(ResultStatus.THROWABLE, e)
        }
    }
}