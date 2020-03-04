package com.example.mindvalley.di

import android.content.Context
import com.example.mindvalley.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityInjector::class,
        ViewModelInjector::class,
        NetModule::class,
        WebServiceModule::class,
        CoreAbstract::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        fun addContext(@BindsInstance context: Context): Builder
        fun build(): AppComponent
    }
}
