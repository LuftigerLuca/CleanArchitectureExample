package eu.luftiger.cae.web.controller

import eu.luftiger.cae.application.common.factory.UseCaseFactory
import eu.luftiger.cae.application.task.usecase.GetTaskUseCase
import eu.luftiger.cae.web.mapper.toDTO
import eu.luftiger.cae.web.presenter.factory.PresenterFactory
import eu.luftiger.cae.web.presenter.task.TaskPresenter
import eu.luftiger.cae.web.schema.task.request.GetTaskRequestSchema
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/task")
internal class TaskController(
    private val useCaseFactory: UseCaseFactory,
    private val presenterFactory: PresenterFactory
) {

    @GetMapping("/{taskId}")
    fun getTask(@PathVariable taskId: String) {
        val presenter = presenterFactory.make(TaskPresenter::class)
        val useCase = useCaseFactory.make(GetTaskUseCase::class)

        val request = GetTaskRequestSchema(taskId = taskId)
        useCase.execute(request.toDTO(), presenter)
    }
}