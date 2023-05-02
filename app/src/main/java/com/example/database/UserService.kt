package com.example.database

import retrofit2.http.GET

interface UserService {
    // http requests(GET POST UPDATE DELETE)
    @GET("/users")
    suspend fun fetchUsers() : List<User>
}