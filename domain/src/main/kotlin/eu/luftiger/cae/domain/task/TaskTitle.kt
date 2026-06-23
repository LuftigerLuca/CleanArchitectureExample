package eu.luftiger.cae.domain.task

import eu.luftiger.cae.domain.result.Problem
import eu.luftiger.cae.domain.result.Result
import eu.luftiger.cae.domain.result.maxLength
import eu.luftiger.cae.domain.result.notBlank
import eu.luftiger.cae.domain.result.validateWithResult

@JvmInline
value class TaskTitle private constructor(val value: String) {

    companion object {
        fun of(value: String): Result<TaskTitle> = validateWithResult {
            notBlank("title", value)
            maxLength("title", value, 100)

            success { TaskTitle(value) }
        }
    }
}
