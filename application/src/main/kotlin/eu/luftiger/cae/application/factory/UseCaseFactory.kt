package eu.luftiger.cae.application.factory

import eu.luftiger.cae.application.InputBoundary
import kotlin.reflect.KClass

interface UseCaseFactory {
    fun <RQ, RS, I : InputBoundary<RQ, RS>> make(inputBoundary: KClass<out I>): I
}