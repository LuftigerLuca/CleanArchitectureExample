package eu.luftiger.cae.domain.user

import eu.luftiger.cae.domain.result.notBlank
import eu.luftiger.cae.domain.result.validateWithResult
import eu.luftiger.cae.domain.result.Result

@JvmInline
value class PasswordHash private constructor(val value: String) {

    companion object {
        fun of(value: String): Result<PasswordHash> = validateWithResult {
            notBlank("passwordHash", value)

            success { PasswordHash(value) }
        }
    }
}
