package com.chi.commonbase

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseFragment<DB : ViewDataBinding,VM : BaseViewModel> : DaggerFragment(){

    @Inject lateinit var mViewModel : VM
    abstract val viewModelClass: KClass<VM>
    @LayoutRes protected abstract fun layoutId(): Int
    @Inject lateinit var factories: ViewModelProvider.Factory
    protected lateinit var mBinding: DB

    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // https://stackoverflow.com/a/57548011/3496570
        mViewModel = ViewModelProvider(this,factories)[viewModelClass.java]
        ///mViewModel = getViewModel()//ViewModelProvider(this,factories)[VM::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater,layoutId(),container,false)
        mBinding.lifecycleOwner = this
        return mBinding.root
    }

    /*fun <T : ViewModel> getViewModel(activity: AppCompatActivity, type: Class<T>): T {
        return ViewModelProvider(activity,factories).get(type)
        ///return ViewModelProviders.of(activity, factories).get(type)
    }*/

    /*inline fun <reified VM : ViewModel> getViewModel(): VM {
        return ViewModelProvider(this, factories)[VM::class.java]
    }*/

    open fun showProgress(title: String?) {
        this.showProgress(title, "Please wait")
    }

    open fun showProgress(title: String?, message: String?) {
        activity?.let {
            if (progressDialog == null) {
                progressDialog = ProgressDialog(it)
                progressDialog!!.isIndeterminate = true
                progressDialog!!.setCanceledOnTouchOutside(false)
                progressDialog!!.setCancelable(false)
            }
            progressDialog!!.setTitle(title)
            progressDialog!!.setMessage(message)
            progressDialog!!.show()
        }
    }

    open fun hideProgress() {
        if (progressDialog != null) {
            progressDialog!!.dismiss()
        }
    }

}