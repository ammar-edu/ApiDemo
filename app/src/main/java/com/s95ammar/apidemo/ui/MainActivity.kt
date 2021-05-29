package com.s95ammar.apidemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.s95ammar.apidemo.R
import com.s95ammar.apidemo.model.api.responses.Post

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        viewModel.getPosts()
//        viewModel.getPost(10)
        viewModel.getPost(1, "title")

/*
        viewModel.getPost(
            mapOf(
                "userId" to "1",
                "_sort" to "title"
            )
        )
*/

/*
        viewModel.createPost(
            Post(
                userId = 50,
                title = "this is the title",
                body = "bla bla bla"
            )
        )
*/

/*
        viewModel.requestWithCustomHeaders(
            dynamicHeader = "dh",
            headersMap = mapOf(
                "header1" to "header1 value",
                "header2" to "header2 value",
                "header3" to "header3 value",
            )
        )
*/
    }
}