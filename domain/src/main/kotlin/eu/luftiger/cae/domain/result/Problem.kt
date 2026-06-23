package eu.luftiger.cae.domain.result

sealed class Problem {
    sealed class Validation(val field: String) : Problem() {
        class Empty(field: String) : Validation(field)
        class TooLong(field: String, val maxLength: Int) : Validation(field)
        class TooShort(field: String, val minLength: Int) : Validation(field)
        class InvalidFormat(field: String) : Validation(field)
    }
}


