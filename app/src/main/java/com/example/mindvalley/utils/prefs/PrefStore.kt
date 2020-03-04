package com.example.mindvalley.utils.prefs

interface PrefStore {

    fun getString(key: String, def: String = ""): String
    fun getBoolean(key: String, def: Boolean = false): Boolean

    fun saveString(key: String, value: String?)
    fun saveBoolean(key: String, value: Boolean?)

    fun getInt(key: String, value: Int = 0): Int
    fun saveInt(key: String, value: Int)

    fun remove(key: String)

}