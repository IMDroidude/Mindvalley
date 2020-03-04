package com.example.mindvalley.di

import com.example.mindvalley.utils.prefs.PrefStore
import com.example.mindvalley.utils.prefs.Prefs
import com.example.mindvalley.utils.prefs.PrefsImpl
import com.example.mindvalley.utils.prefs.SharedPrefStore
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class CoreAbstract {

    @Binds
    @Singleton
    abstract fun provideSharedPrefs(sharedPrefs: SharedPrefStore): PrefStore

    @Binds
    @Singleton
    abstract fun provideTalkhomePrefs(talkhomePrefs: PrefsImpl): Prefs
}
