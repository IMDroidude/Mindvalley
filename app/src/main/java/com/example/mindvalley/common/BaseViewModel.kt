package com.example.mindvalley.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mindvalley.model.Failure

abstract class BaseViewModel : ViewModel() {

    var failure: MutableLiveData<Failure> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }
}