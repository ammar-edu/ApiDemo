package com.s95ammar.apidemo.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.s95ammar.apidemo.model.api.responses.Post
import com.s95ammar.apidemo.model.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {

    private val disposables = CompositeDisposable()

    fun getPosts() {
        disposables.add(
            Repository.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ posts ->
                    Log.d("MainViewModel", "Success\n" + posts)
                }, { throwable ->
                    Log.e("MainViewModel", "Error\n" + throwable.message.toString())
                })
        )
    }

    fun getPost(id: Int) {
        disposables.add(
            Repository.getPost(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ post ->
                    Log.d("MainViewModel", "Success\n" + post)
                }, { throwable ->
                    Log.e("MainViewModel", "Error\n" + throwable.message.toString())
                })
        )
    }

    fun getPost(userId: Int, sort: String) {
        disposables.add(
            Repository.getPost(userId, sort)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ post ->
                    Log.d("MainViewModel", "Success\n" + post)
                }, { throwable ->
                    Log.e("MainViewModel", "Error\n" + throwable.message.toString())
                })
        )
    }

    fun getPost(parameters: Map<String, String>) {
        disposables.add(
            Repository.getPost(parameters)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ post ->
                    Log.d("MainViewModel", "Success\n" + post)
                }, { throwable ->
                    Log.e("MainViewModel", "Error\n" + throwable.message.toString())
                })
        )
    }

    fun createPost(post: Post) {
        disposables.add(
            Repository.createPost(post)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ createdPost ->
                    Log.d("MainViewModel", "Success\n" + createdPost + " id = ${createdPost.id}")
                }, { throwable ->
                    Log.e("MainViewModel", "Error\n" + throwable.message.toString())
                })
        )
    }

    fun requestWithCustomHeaders(
        dynamicHeader: String,
        headersMap: Map<String, String>
    ) {
        disposables.add(
            Repository.requestWithCustomHeaders(dynamicHeader, headersMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("MainViewModel", "Success\n")
                }, { throwable ->
                    Log.e("MainViewModel", "Error\n" + throwable.message.toString())
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (!disposables.isDisposed)
            disposables.dispose()
    }
}