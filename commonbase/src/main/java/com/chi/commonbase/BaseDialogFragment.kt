package com.chi.commonbase

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerDialogFragment
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseDialogFragment<DB : ViewDataBinding,VM : BaseViewModel> : DaggerDialogFragment(){

    @Inject lateinit var mViewModel : VM
    abstract val viewModelClass: KClass<VM>
    @LayoutRes protected abstract fun layoutId(): Int
    @Inject lateinit var factories: ViewModelProvider.Factory
    protected lateinit var mBinding: DB

    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this,factories)[viewModelClass.java]
    }

    override fun onStart() {
        super.onStart()

        val dialog = getDialog()
        dialog?.let {
            it.window?.let {
                dialog.window?.setLayout(MATCH_PARENT,WRAP_CONTENT)
            }
        }
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


    open fun showProgress(title: String?) {
        this.showProgress(title, "Please wait")
    }

    open fun showProgress(title: String?, message: String?) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(requireActivity())
            progressDialog!!.isIndeterminate = true
            progressDialog!!.setCanceledOnTouchOutside(false)
            progressDialog!!.setCancelable(false)
        }
        progressDialog!!.setTitle(title)
        progressDialog!!.setMessage(message)
        progressDialog!!.show()
    }

    open fun hideProgress() {
        if (progressDialog != null) {
            progressDialog!!.dismiss()
        }
    }
}