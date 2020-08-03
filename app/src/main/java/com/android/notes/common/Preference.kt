package com.android.notes.common

import android.content.Context
import android.content.SharedPreferences
import com.android.notes.BuildConfig
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * SharedPreferences封装
 */
class Preference<T>(
    private val context: Context,
    private val name: String,
    private val default: T
) :
    ReadWriteProperty<Any?, T> {

    private val spFileName: String = BuildConfig.APPLICATION_ID // 文件名

    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences(spFileName, Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreference(name, default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name, value)
    }

    private fun <T> findPreference(name: String, default: T): T = with(prefs) {
        val res: T = when (default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else -> throw IllegalArgumentException("This type can not be saved into Preferences")
        } as T
        res
    }

    private fun <U> putPreference(name: String, value: U) = with(prefs.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> throw IllegalArgumentException("This type can be saved into Preferences")
        }.apply()
    }

}