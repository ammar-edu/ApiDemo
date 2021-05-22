package com.s95ammar.apidemo.model.api

import com.s95ammar.apidemo.model.api.responses.Post
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun getPosts(): Single<List<Post>>
}
