package eu.luftiger.cae.web.mapper

import eu.luftiger.cae.application.task.usecase.GetTaskRequest
import eu.luftiger.cae.web.schema.task.request.GetTaskRequestSchema

fun GetTaskRequest.toSchema() = GetTaskRequestSchema(
    taskId = this.taskId
)

fun GetTaskRequestSchema.toDTO() = GetTaskRequest(
    taskId = this.taskId
)