package io.github.lumkit.krigin.common.preference

import java.util.prefs.Preferences

class JvmPreferenceImpl(private val prefs: Preferences) : Preference {
    override fun getString(key: String, defaultVale: String?): String? = prefs.get(key, defaultVale)
    override fun getInt(key: String, defaultVale: Int): Int = prefs.getInt(key, defaultVale)
    override fun getLong(key: String, defaultVale: Long): Long = prefs.getLong(key, defaultVale)
    override fun getFloat(key: String, defaultVale: Float): Float = prefs.getFloat(key, defaultVale)
    override fun getBoolean(key: String, defaultVale: Boolean): Boolean = prefs.getBoolean(key, defaultVale)

    override fun putString(key: String, value: String) { prefs.put(key, value) }
    override fun putInt(key: String, value: Int) { prefs.putInt(key, value) }
    override fun putLong(key: String, value: Long) { prefs.putLong(key, value) }
    override fun putFloat(key: String, value: Float) { prefs.putFloat(key, value) }
    override fun putBoolean(key: String, value: Boolean) { prefs.putBoolean(key, value) }

    override fun remove(key: String) { prefs.remove(key) }
    override fun clear() { prefs.clear() }
}

/**
 * 获取多平台首选项
 */
actual fun preferencePlatform(key: String): Preference = JvmPreferenceImpl(
    Preferences.userRoot().node(key)
)