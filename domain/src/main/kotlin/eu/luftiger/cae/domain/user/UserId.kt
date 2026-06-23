package eu.luftiger.cae.domain.user

import eu.luftiger.cae.domain.result.Result
import eu.luftiger.cae.domain.result.notBlank
import eu.luftiger.cae.domain.result.validateWithResult
import eu.luftiger.cae.domain.task.TaskId
import java.util.UUID

@JvmInline
value class UserId private constructor(val value: String) {

    companion object {
        fun of(value: String): Result<UserId> = validateWithResult {
            notBlank("id", value)

            success { UserId(value) }
        }

        fun generate() = of(UUID.randomUUID().toString())
    }
}