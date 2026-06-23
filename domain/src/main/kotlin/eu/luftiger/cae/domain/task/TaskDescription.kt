package eu.luftiger.cae.domain.task

import eu.luftiger.cae.domain.result.Problem
import eu.luftiger.cae.domain.result.Result
import eu.luftiger.cae.domain.result.maxLength
import eu.luftiger.cae.domain.result.notBlank
import eu.luftiger.cae.domain.result.validateWithResult

@JvmInline
value class TaskDescription private constructor(val value: String) {

    companion object {
        fun of(value: String): Result<TaskDescription> = validateWithResult {
            notBlank("description", value)
            maxLength("description", value, 500)

            success { TaskDescription(value) }
        }
    }
}
