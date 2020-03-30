package com.lazyxu.base.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import java.io.IOException


open class BaseRepository {
    suspend fun <T : Any> safeApiCall(call: suspend () -> RespondResult<T>, errorMessage: String): RespondResult<T> {
        return try {
            call()
        } catch (e: Exception) {
            RespondResult.Error(IOException(errorMessage, e))
        }
    }

    suspend fun <T : Any> executeResponse(response: BaseBean<T>, successBlock: (suspend CoroutineScope.() -> Unit)? = null,
                                          errorBlock: (suspend CoroutineScope.() -> Unit)? = null): RespondResult<T> {
        return coroutineScope {
            if (response.errorCode == -1) {
                errorBlock?.let { it() }
                RespondResult.Error(IOException(response.errorMsg))
            } else {
                successBlock?.let { it() }
                RespondResult.Success(response.data)
            }
        }
    }


}