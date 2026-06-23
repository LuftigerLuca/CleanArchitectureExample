package eu.luftiger.cae.domain.result

class ValidationDSL<T> {
    private val problems = mutableListOf<Problem>()
    private var factory: (() -> T)? = null

    fun rule(condition: () -> Boolean, problem: () -> Problem) {
        if (condition()) problems.add(problem())
    }

    @Suppress("UNCHECKED_CAST")
    fun <R> resolve(block: () -> Result<R>): R {
        return when (val result = block()) {
            is Result.Success -> result.value
            is Result.Failure -> {
                problems.addAll(result.problems)
                null as R
            }
        }
    }

    fun success(block: () -> T) {
        factory = block
    }

    fun build(): Result<T> {
        val f = factory ?: throw IllegalStateException("success block required")
        return if (problems.isEmpty()) Result.Success(f())
        else Result.Failure(problems)
    }
}

fun <T> validateWithResult(block: ValidationDSL<T>.() -> Unit): Result<T> =
    ValidationDSL<T>().apply(block).build()

fun ValidationDSL<*>.notBlank(field: String, value: String) {
    rule({ value.isBlank() }) { Problem.Validation.Empty(field) }
}

fun ValidationDSL<*>.maxLength(field: String, value: String, maxLength: Int) {
    rule({ value.length > maxLength }) { Problem.Validation.TooLong(field, maxLength) }
}

fun ValidationDSL<*>.minLength(field: String, value: String, minLength: Int) {
    rule({ value.length <= minLength }) { Problem.Validation.TooShort(field, minLength) }
}