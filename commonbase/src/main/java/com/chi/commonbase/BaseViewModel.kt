package com.chi.commonbase

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel() : ViewModel() {

    val compositeDisposable = CompositeDisposable()

    /*protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }*/

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    data class ErrorCode(val title: String,val message: String,val errorCode:Int)
}