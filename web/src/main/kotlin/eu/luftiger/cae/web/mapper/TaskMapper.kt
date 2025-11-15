package eu.luftiger.cae.web.mapper

import eu.luftiger.cae.application.task.dto.TaskDTO
import eu.luftiger.cae.web.schema.task.TaskSchema

fun TaskDTO.toSchema() = TaskSchema(
    id = this.id,
    title = this.title,
    description = this.description,
    isCompleted = this.isCompleted
)

fun TaskSchema.toDTO() = TaskDTO(
    id = this.id,
    title = this.title,
    description = this.description,
    isCompleted = this.isCompleted
)