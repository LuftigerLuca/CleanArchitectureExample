package eu.luftiger.cae.application.factory

import eu.luftiger.cae.application.InputBoundary
import kotlin.reflect.KClass

class UseCaseFactoryImpl : UseCaseFactory {

    private val useCases: Map<KClass<out InputBoundary<*, *>>, InputBoundary<*, *>> =
        mapOf()

    override fun <RQ, RS, I : InputBoundary<RQ, RS>> make(inputBoundary: KClass<out I>): I {
        @Suppress("UNCHECKED_CAST")
        return useCases[inputBoundary] as I
    }
}