package com.sumit.network.utils

import com.sumit.common.CoroutineDispatcherProvider
import com.sumit.common.Constants
import com.sumit.common.Constants.API_ERROR
import kotlinx.coroutines.withContext
import retrofit2.Response

suspend fun <T, R> apiCallToResult(
    apiCall: suspend () -> Response<T>,
    transform: suspend (T) -> Result<R>,
    mapError: ((Throwable) -> String)? = null,
    coroutineDispatcher: CoroutineDispatcherProvider,
): Result<R> =
    withContext(coroutineDispatcher.io()) {
        runCatching {
            val response = apiCall.invoke()
            if (response.isSuccessful) {
                val body =
                    response.body() ?: throw IllegalStateException(Constants.MALFORMED_DATA_ERROR)
                transform(body)
            } else {
                val error = response.errorBody()?.string()
                Result.failure(IllegalStateException("$API_ERROR $error"))
            }
        }.getOrElse { e ->
            mapError?.let {
                Result.failure(e)
            } ?: Result.failure(IllegalStateException())
        }
    }