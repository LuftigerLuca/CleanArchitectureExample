package eu.luftiger.cae.domain.user

@JvmInline
value class UserId(val value: String) {
    init {
        require(value.isNotEmpty()) { "Id cannot be empty" }
    }
}