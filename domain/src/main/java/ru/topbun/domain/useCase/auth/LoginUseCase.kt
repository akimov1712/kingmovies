package ru.topbun.domain.useCase.auth

import ru.topbun.domain.entity.auth.AuthMethods
import ru.topbun.domain.repository.auth.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(method: AuthMethods) = repository.login(method)

}