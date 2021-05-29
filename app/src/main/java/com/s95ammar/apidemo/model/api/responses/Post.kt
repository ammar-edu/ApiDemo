package com.s95ammar.apidemo.model.api.responses

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("userId")
    val userId: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("body")
    val body: String?
) {
    @SerializedName("id")
    var id: Int? = null

}
