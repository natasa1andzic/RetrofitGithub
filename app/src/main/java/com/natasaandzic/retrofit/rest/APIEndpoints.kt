package com.natasaandzic.retrofit.rest

import com.natasaandzic.retrofit.model.Repo
import com.natasaandzic.retrofit.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

class APIEndpoints {


    interface UserEndpoints {
        @GET("/users/{user}")
        fun getUser(@Path("user") username: String) : Call<User>
    }

    interface RepoEndpoint {
        @GET("/users/{user}/repos")
        fun getRepo(@Path("user") name:String) : Call<List<Repo>>
    }
}