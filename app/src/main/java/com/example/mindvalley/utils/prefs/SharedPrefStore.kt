package com.example.mindvalley.utils.prefs

import android.content.Context
import com.example.mindvalley.utils.prefs.PrefStore
import javax.inject.Inject

class SharedPrefStore @Inject constructor(context: Context) :
    PrefStore {

    private val sharedPrefs = context.getSharedPreferences("tkh_prefs", Context.MODE_PRIVATE)

    override fun getInt(key: String, value: Int): Int = sharedPrefs.getInt(key, value)

    override fun saveInt(key: String, value: Int) {
        sharedPrefs.edit().putInt(key, value).apply()
    }

    override fun remove(key: String) {
        sharedPrefs.edit().remove(key).apply()
    }

    override fun getBoolean(key: String, def: Boolean): Boolean {
        return sharedPrefs.getBoolean(key, def)
    }

    override fun saveString(key: String, value: String?) {
        sharedPrefs.edit().putString(key, value).apply()
    }

    override fun saveBoolean(key: String, value: Boolean?) {
        sharedPrefs.edit().putBoolean(key, value ?: false).apply()
    }


    override fun getString(key: String, def: String): String {
        return sharedPrefs.getString(key, def) ?: def
    }
}