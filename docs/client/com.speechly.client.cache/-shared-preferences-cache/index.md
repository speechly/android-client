//[client](../../index.md)/[com.speechly.client.cache](../index.md)/[SharedPreferencesCache](index.md)



# SharedPreferencesCache  
 [androidJvm] class [SharedPreferencesCache](index.md)(**preferences**: [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html)) : [CacheService](../-cache-service/index.md)

An implementation of persistent cache that uses Android shared preferences as the storage. See more at https://developer.android.com/reference/kotlin/android/content/SharedPreferences.



This implementation is not safe to share by multiple applications on the same device. A user must ensure that preference files are not shared by multiple applications by providing app-specific file names.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.cache/SharedPreferencesCache/SharedPreferencesCache/#android.content.SharedPreferences/PointingToDeclaration/"></a>[SharedPreferencesCache](-shared-preferences-cache.md)| <a name="com.speechly.client.cache/SharedPreferencesCache/SharedPreferencesCache/#android.content.SharedPreferences/PointingToDeclaration/"></a> [androidJvm] fun [SharedPreferencesCache](-shared-preferences-cache.md)(preferences: [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.cache/SharedPreferencesCache.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.speechly.client.cache/SharedPreferencesCache.Companion///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open operator fun [equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.speechly.client.cache/SharedPreferencesCache/loadString/#kotlin.String/PointingToDeclaration/"></a>[loadString](load-string.md)| <a name="com.speechly.client.cache/SharedPreferencesCache/loadString/#kotlin.String/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [loadString](load-string.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?  <br>More info  <br>Reads the specified key from the cache and returns the data as string.  <br><br><br>
| <a name="com.speechly.client.cache/SharedPreferencesCache/storeString/#kotlin.String#kotlin.String/PointingToDeclaration/"></a>[storeString](store-string.md)| <a name="com.speechly.client.cache/SharedPreferencesCache/storeString/#kotlin.String#kotlin.String/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [storeString](store-string.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Stores the string value to the cache under specified key.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

