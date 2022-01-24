package com.speechly.client.cache

import android.content.Context
import android.content.SharedPreferences

/**
 * An interface for a persistent cache for storing key-value pairs in the device storage.
 */
interface CacheService {
    /**
     * Reads the specified key from the cache and returns the data as string.
     * If the key is missing or the data cannot be parsed into a string, returns null.
     * @param key the key to read from
     */
    fun loadString(key: String): String?

    /**
     * Stores the string value to the cache under specified key.
     * Returns true if the operation succeeds, false otherwise.
     * @param key the key to write to
     * @param value the value to write
     */
    fun storeString(key: String, value: String): Boolean
}

/**
 * An implementation of persistent cache that uses Android shared preferences as the storage.
 * See more at https://developer.android.com/reference/kotlin/android/content/SharedPreferences.
 *
 * This implementation is not safe to share by multiple applications on the same device.
 * A user must ensure that preference files are not shared by multiple applications
 * by providing app-specific file names.
 */
class SharedPreferencesCache(private val preferences: SharedPreferences) : CacheService {
    companion object {
        const val PREFERENCE_FILE_KEY = "speechly.preferences.cache"

        /**
         * Creates a new shared preferences cache from a context instance.
         * @param context the context to get preferences from
         * @param preferenceFileName the file name to use for storing preferences
         */
        fun fromContext(
                context: Context,
                preferenceFileName: String = PREFERENCE_FILE_KEY
        ): SharedPreferencesCache {
            return SharedPreferencesCache(
                    context.getSharedPreferences(preferenceFileName, Context.MODE_PRIVATE)
            )
        }
    }

    override fun loadString(key: String): String? {
        return try {
            this.preferences.getString(key, null)
        } catch (_: Throwable) {
            null
        }
    }

    override fun storeString(key: String, value: String): Boolean {
        return try {
            with (this.preferences.edit()) {
                putString(key, value)
                apply()
            }

            true
        } catch (_: Throwable) {
            false
        }
    }
}