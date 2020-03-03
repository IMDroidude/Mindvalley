package com.example.mindvalley.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Retention(AnnotationRetention.SOURCE)
annotation class ViewModelKey(
    val value: KClass<out ViewModel>
)