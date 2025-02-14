package ru.topbun.domain.repository.auth

import ru.topbun.domain.entity.auth.AuthMethods

interface AuthRepository {

    suspend fun login(method: AuthMethods)

}