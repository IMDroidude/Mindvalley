package com.example.mindvalley.common

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mindvalley.utils.ViewModelUtil
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<VM:BaseViewModel,DataBindingT: ViewDataBinding> : DaggerAppCompatActivity(){

    @Inject
    lateinit var mViewModel: VM
    /*@Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory*/

    abstract val layoutId : Int
    lateinit var mBinding : DataBindingT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, layoutId)

        //mViewModel = ViewModelProvider(this, viewModelFactory).get(mViewModel::class.java)
        val viewModelFactory = ViewModelUtil.createFor<ViewModel>(mViewModel)
        mViewModel = ViewModelProvider(this, viewModelFactory).get(mViewModel::class.java)
    }
}