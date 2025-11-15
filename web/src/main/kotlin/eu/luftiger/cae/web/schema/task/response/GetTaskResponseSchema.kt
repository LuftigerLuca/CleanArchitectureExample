package eu.luftiger.cae.web.schema.task.response

import eu.luftiger.cae.web.schema.task.TaskSchema

data class GetTaskResponseSchema(
    val task: TaskSchema
)