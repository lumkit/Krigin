package io.github.lumkit.krigin.common.preference

import platform.Foundation.NSUserDefaults

class IosPreferenceImpl(private val defaults: NSUserDefaults, private val prefix: String) : Preference {
    override fun getString(key: String, defaultVale: String?): String? =
        defaults.stringForKey(prefix + key) ?: defaultVale

    override fun getInt(key: String, defaultVale: Int): Int = defaults.integerForKey(prefix + key).toInt()
    override fun getLong(key: String, defaultVale: Long): Long =
        defaults.objectForKey(prefix + key) as? Long ?: defaultVale

    override fun getFloat(key: String, defaultVale: Float): Float = defaults.floatForKey(prefix + key)
    override fun getBoolean(key: String, defaultVale: Boolean): Boolean = defaults.boolForKey(prefix + key)

    override fun putString(key: String, value: String) {
        defaults.setObject(value, prefix + key)
    }

    override fun putInt(key: String, value: Int) {
        defaults.setInteger(value.toLong(), prefix + key)
    }

    override fun putLong(key: String, value: Long) {
        defaults.setObject(value, prefix + key)
    }

    override fun putFloat(key: String, value: Float) {
        defaults.setFloat(value, prefix + key)
    }

    override fun putBoolean(key: String, value: Boolean) {
        defaults.setBool(value, prefix + key)
    }

    override fun remove(key: String) {
        defaults.removeObjectForKey(prefix + key)
    }

    override fun clear() {
        defaults.dictionaryRepresentation().keys.forEach { defaults.removeObjectForKey(prefix + it as String) }
    }
}

/**
 * 获取多平台首选项
 */
actual fun preferencePlatform(key: String): Preference = IosPreferenceImpl(
    NSUserDefaults.standardUserDefaults(), "${key}."
)