package eu.luftiger.cae.web.schema.task

import java.io.Serializable

data class TaskSchema(
    val id: String,
    val title: String,
    val description: String,
    val isCompleted: Boolean
) : Serializable