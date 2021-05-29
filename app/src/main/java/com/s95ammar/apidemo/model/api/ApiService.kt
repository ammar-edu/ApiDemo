package com.s95ammar.apidemo.model.api

import com.s95ammar.apidemo.model.api.responses.Post
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface ApiService {

    @GET("posts")
    fun getPosts(): Single<List<Post>>

    @GET("posts/{id}")
    fun getPost(@Path("id") postId: Int): Single<Post>

    @GET("posts")
    fun getPost(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String
    ): Single<List<Post>>

    @GET("posts")
    fun getPost(@QueryMap parameters: Map<String, String>): Single<List<Post>>

    @POST("posts")
    fun createPost(@Body post: Post): Single<Post>

    @POST("posts")
    fun createPost(
        @Field("userId") userId: Int,
        @Field("title") title: String,
        @Field("body") body: String
    ): Single<Post> // retrofit creates a body from the @Field parameters

    @Headers("static_header: header_value")
    @GET("posts")
    fun requestWithCustomHeaders(
        @Header("dynamic_header") dynamicHeader: String,
        @HeaderMap headersMap: Map<String, String>
    ): Completable
}
