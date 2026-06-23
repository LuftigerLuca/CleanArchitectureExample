package eu.luftiger.cae.domain.task

import eu.luftiger.cae.domain.result.Result
import eu.luftiger.cae.domain.result.validateWithResult

data class Task(
    val id: TaskId,
    val title: TaskTitle,
    val description: TaskDescription,
    val isCompleted: Boolean
) {
    companion object {
        fun of(id: String? = null, title: String, description: String, isCompleted: Boolean): Result<Task> = validateWithResult {
            val validTitle = resolve { TaskTitle.of(title) }
            val validDescription = resolve { TaskDescription.of(description) }
            val validId = resolve { if (id == null) TaskId.generate() else TaskId.of(id) }

            success { Task(validId, validTitle, validDescription, isCompleted) }
        }
    }
}