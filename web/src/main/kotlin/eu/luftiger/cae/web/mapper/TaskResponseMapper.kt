package eu.luftiger.cae.web.mapper

import eu.luftiger.cae.application.task.usecase.GetTaskResponse
import eu.luftiger.cae.web.schema.task.response.GetTaskResponseSchema

fun GetTaskResponse.toSchema() = GetTaskResponseSchema(
    task = this.task.toSchema()
)

fun GetTaskResponseSchema.toDTO() = GetTaskResponse(
    task = this.task.toDTO()
)