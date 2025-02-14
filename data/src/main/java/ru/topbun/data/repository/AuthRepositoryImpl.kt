package ru.topbun.data.repository

import ru.topbun.domain.entity.auth.AuthMethods
import ru.topbun.domain.repository.auth.AuthRepository

class AuthRepositoryImpl: AuthRepository {

    override suspend fun login(method: AuthMethods) {

    }

}