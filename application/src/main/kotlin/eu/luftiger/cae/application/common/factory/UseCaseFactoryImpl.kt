package eu.luftiger.cae.application.common.factory

import eu.luftiger.cae.application.common.InputBoundary
import eu.luftiger.cae.application.task.usecase.GetTaskUseCase
import eu.luftiger.cae.application.task.usecase.GetTaskUseCaseImpl
import kotlin.reflect.KClass

class UseCaseFactoryImpl : UseCaseFactory {

    private val useCases: Map<KClass<out InputBoundary<*, *>>, InputBoundary<*, *>> =
        mapOf(GetTaskUseCase::class to GetTaskUseCaseImpl())

    override fun <RQ, RS, I : InputBoundary<RQ, RS>> make(inputBoundary: KClass<out I>): I {
        @Suppress("UNCHECKED_CAST")
        return useCases[inputBoundary] as I
    }
}