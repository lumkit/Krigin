package io.github.lumkit.krigin.common.preference

import kotlinx.browser.localStorage

class WasmJsPreferenceImpl(private val prefix: String) : Preference {
    override fun getString(key: String, defaultVale: String?): String? = localStorage.getItem(prefix + key) ?: defaultVale
    override fun getInt(key: String, defaultVale: Int): Int = localStorage.getItem(prefix + key)?.toIntOrNull() ?: defaultVale
    override fun getLong(key: String, defaultVale: Long): Long = localStorage.getItem(prefix + key)?.toLongOrNull() ?: defaultVale
    override fun getFloat(key: String, defaultVale: Float): Float = localStorage.getItem(prefix + key)?.toFloatOrNull() ?: defaultVale
    override fun getBoolean(key: String, defaultVale: Boolean): Boolean = localStorage.getItem(prefix + key)?.toBooleanStrictOrNull() ?: defaultVale

    override fun putString(key: String, value: String) { localStorage.setItem(prefix + key, value) }
    override fun putInt(key: String, value: Int) { localStorage.setItem(prefix + key, value.toString()) }
    override fun putLong(key: String, value: Long) { localStorage.setItem(prefix + key, value.toString()) }
    override fun putFloat(key: String, value: Float) { localStorage.setItem(prefix + key, value.toString()) }
    override fun putBoolean(key: String, value: Boolean) { localStorage.setItem(prefix + key, value.toString()) }

    override fun remove(key: String) { localStorage.removeItem(prefix + key) }
    override fun clear() { localStorage.clear() }
}

/**
 * 获取多平台首选项
 */
actual fun preferencePlatform(key: String): Preference = WasmJsPreferenceImpl(key)