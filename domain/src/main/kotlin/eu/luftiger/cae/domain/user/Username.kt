package eu.luftiger.cae.domain.user

import eu.luftiger.cae.domain.result.Problem
import eu.luftiger.cae.domain.result.Result
import eu.luftiger.cae.domain.result.maxLength
import eu.luftiger.cae.domain.result.minLength
import eu.luftiger.cae.domain.result.notBlank
import eu.luftiger.cae.domain.result.validateWithResult

@JvmInline
value class Username private constructor(val value: String) {

    companion object {
        fun of(value: String): Result<Username> = validateWithResult {
            notBlank("username", value)
            maxLength("username", value, 30)
            minLength("username", value, 3)

            rule({ value.all { it.isLetterOrDigit() || it == '_' } }) { Problem.Validation.InvalidFormat("username") }

            success { Username(value) }
        }
    }
}