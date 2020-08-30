package com.chi.commonbase

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<DB : ViewDataBinding,VM : BaseViewModel> : DaggerAppCompatActivity(){

    @Inject lateinit var mViewModel : VM
    @LayoutRes protected abstract fun layoutId(): Int
    @Inject lateinit var factories: ViewModelProvider.Factory
    protected lateinit var mBinding: DB
    abstract fun showToolbar():Boolean
    abstract val appBarTitle: String

    var progressDialog: ProgressDialog? = null

    //override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(!showToolbar()) supportActionBar?.hide()
        ///ThemeUtils.setTheme(this)
        ///setContentView(getViewBinding().root)

        mBinding = DataBindingUtil.setContentView(this, layoutId())
        ///mViewModel = ViewModelProvider(this, factories).get(mViewModel::class.java)
        mViewModel = getViewModel(this,mViewModel::class.java)
        mBinding.lifecycleOwner = this

        //FIXME bind mViewModel && activity here as well but make sure they exist in all layouts
        // set theme here
        // handle toolbar actions here
    }

    fun replaceFragment(containerViewId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(containerViewId, fragment)
            .commit()
    }

    open fun hideKeyboard() {
        try {
            val inputmanager =
                this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputmanager.hideSoftInputFromWindow(this.currentFocus!!.windowToken, 0)
        } catch (var2: Exception) {
        }
    }

    open fun showProgress(title: String?) {
        this.showProgress(title, "Please wait")
    }

    open fun showProgress(title: String?, message: String?) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this)
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

    //use below code like
    //private val binding by binding<ActivityDetailBinding>(R.layout.activity_detail) // in child activity
    /*protected inline fun <reified T : ViewDataBinding> binding(@LayoutRes resId: Int): Lazy<T> =
        lazy { DataBindingUtil.setContentView<T>(this, resId) }

    inline fun <reified T : ViewDataBinding> getBinding(@LayoutRes layoutId: Int): T {
        return DataBindingUtil.setContentView(this, layoutId)
    }*/

    fun <T : ViewModel> getViewModel(activity: AppCompatActivity, type: Class<T>): T {
        return ViewModelProvider(activity,factories).get(type)
        ///return ViewModelProviders.of(activity, factories).get(type)
    }

    inline fun <reified T : Activity> Context.startActivity(block: Intent.() -> Unit = {}) {
        val intent = Intent(this, T::class.java)
        block(intent)
        startActivity(intent)
    }

    fun onHideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
        // else {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        // }
    }

}

