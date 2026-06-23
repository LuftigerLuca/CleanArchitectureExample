package eu.luftiger.cae.domain.result

import java.util.concurrent.locks.Condition

sealed class Result<out T> {
    data class Success<T>(val value: T) : Result<T>()
    data class Failure(val problems: List<Problem>) : Result<Nothing>()

    val isSuccess get() = this is Success
    val isFailure get() = this is Failure
}