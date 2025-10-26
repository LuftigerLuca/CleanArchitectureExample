package eu.luftiger.cae.application

interface OutputBoundary<R> {
    fun present(response: R)
}