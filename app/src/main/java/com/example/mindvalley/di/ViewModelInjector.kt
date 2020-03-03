package com.example.mindvalley.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mindvalley.common.BaseViewModel
import com.example.mindvalley.viewmodels.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.*
import javax.inject.Provider

@Module
//@Module(includes = [ViewModelInjector.Factory::class])
abstract class ViewModelInjector {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun provideITSplashViewModel(model: MainActivityViewModel) : BaseViewModel


    @Module
    class Factory {
        @Provides
        fun provideFactory(factories: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>):
                ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {

                    @Suppress("UNCHECKED_CAST")
                    return Objects.requireNonNull(factories[modelClass]?.get() as T)
                }

            }
        }
    }
}
