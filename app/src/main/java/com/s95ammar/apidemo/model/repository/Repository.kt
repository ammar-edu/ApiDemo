package com.s95ammar.apidemo.model.repository

import com.s95ammar.apidemo.model.api.ApiService
import com.s95ammar.apidemo.model.api.responses.Post
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repository {

    private val apiService = createApiService()

    fun getPosts(): Single<List<Post>> {
        return apiService.getPosts()
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    private fun createApiService(): ApiService {
        val retrofit = createRetrofit()
        return retrofit.create(ApiService::class.java)
    }
}