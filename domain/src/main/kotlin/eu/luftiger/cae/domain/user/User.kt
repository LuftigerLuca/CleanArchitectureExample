package eu.luftiger.cae.domain.user

import eu.luftiger.cae.domain.result.validateWithResult
import eu.luftiger.cae.domain.result.Result

data class User private constructor(
    val id: UserId,
    val username: Username,
    val passwordHash: PasswordHash
) {
    companion object {
        fun of(id: String? = null, username: String, passwordHash: String): Result<User> = validateWithResult {
            val validUsername = resolve { Username.of(username) }
            val validPasswordHash = resolve { PasswordHash.of(username) }
            val validId = resolve { if (id == null) UserId.generate() else UserId.of(id) }

            success { User(validId, validUsername, validPasswordHash) }
        }
    }
}