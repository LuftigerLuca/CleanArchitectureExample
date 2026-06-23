package eu.luftiger.cae.domain.task

import eu.luftiger.cae.domain.result.Problem
import eu.luftiger.cae.domain.result.Result
import eu.luftiger.cae.domain.result.notBlank
import eu.luftiger.cae.domain.result.validateWithResult
import java.util.UUID

@JvmInline
value class TaskId private constructor(val value: String) {

    companion object {
        fun of(value: String): Result<TaskId> = validateWithResult {
            notBlank("id", value)

            success { TaskId(value) }
        }

        fun generate() = of(UUID.randomUUID().toString())
    }
}
