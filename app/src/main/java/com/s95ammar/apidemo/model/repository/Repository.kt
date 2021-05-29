package com.s95ammar.apidemo.model.repository

import com.s95ammar.apidemo.model.api.ApiService
import com.s95ammar.apidemo.model.api.responses.Post
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Header
import retrofit2.http.HeaderMap

object Repository {

    private val apiService = createApiService()

    fun getPosts(): Single<List<Post>> {
        return apiService.getPosts()
    }

    fun getPost(postId: Int): Single<Post> {
        return apiService.getPost(postId)
    }

    fun getPost(userId: Int, sort: String): Single<List<Post>> {
        return apiService.getPost(userId, sort)
    }

    fun getPost(parameters: Map<String, String>): Single<List<Post>> {
        return apiService.getPost(parameters)
    }

    fun createPost(post: Post): Single<Post> {
        return apiService.createPost(post)
    }

    fun requestWithCustomHeaders(
        dynamicHeader: String,
        headersMap: Map<String, String>
    ): Completable {
        return apiService.requestWithCustomHeaders(dynamicHeader, headersMap)
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(createClient())
            .build()
    }

    private fun createClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request()

                val newRequest = request.newBuilder()
                    .header("token", "secret123456789")
                    .build()

                return@addInterceptor chain.proceed(newRequest)
            }
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    private fun createApiService(): ApiService {
        val retrofit = createRetrofit()
        return retrofit.create(ApiService::class.java)
    }
}