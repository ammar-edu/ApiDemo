package com.s95ammar.apidemo.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.s95ammar.apidemo.model.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {

    fun getPosts() {
        Repository.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ posts ->
                Log.d("MainViewModel", "Success\n" + posts)
            }, { throwable ->
                Log.e("MainViewModel", "Error\n" + throwable.message.toString())
            })
    }
}