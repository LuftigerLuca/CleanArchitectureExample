package eu.luftiger.cae.application

interface InputBoundary<RQ, RS> {
    fun execute(request: RQ, presenter: OutputBoundary<RS>)
}