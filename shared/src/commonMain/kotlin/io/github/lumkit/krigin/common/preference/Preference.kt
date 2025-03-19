package io.github.lumkit.krigin.common.preference

interface Preference {
    fun getString(key: String, defaultVale: String? = null): String?
    fun getInt(key: String, defaultVale: Int = 0): Int
    fun getLong(key: String, defaultVale: Long = 0L): Long
    fun getFloat(key: String, defaultVale: Float = 0f): Float
    fun getBoolean(key: String, defaultVale: Boolean = false): Boolean

    fun putString(key: String, value: String)
    fun putInt(key: String, value: Int)
    fun putLong(key: String, value: Long)
    fun putFloat(key: String, value: Float)
    fun putBoolean(key: String, value: Boolean)
    fun remove(key: String)
    fun clear()
}