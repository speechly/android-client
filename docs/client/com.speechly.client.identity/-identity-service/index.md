//[client](../../index.md)/[com.speechly.client.identity](../index.md)/[IdentityService](index.md)



# IdentityService  
 [androidJvm] interface [IdentityService](index.md) : [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)

An interface for a service that returns authentication tokens obtained from Speechly Identity API.

   


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.identity/IdentityService/authenticate/#java.util.UUID#java.util.UUID/PointingToDeclaration/"></a>[authenticate](authenticate.md)| <a name="com.speechly.client.identity/IdentityService/authenticate/#java.util.UUID#java.util.UUID/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>abstract suspend fun [authenticate](authenticate.md)(appId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), deviceId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)): [AuthToken](../-auth-token/index.md)  <br>More info  <br>Fetches a new authentication token and decodes it into AuthToken.  <br><br><br>
| <a name="java.io/Closeable/close/#/PointingToDeclaration/"></a>[close](../../com.speechly.client.speech/-api-client/index.md#%5Bjava.io%2FCloseable%2Fclose%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)| <a name="java.io/Closeable/close/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>abstract override fun [close](../../com.speechly.client.speech/-api-client/index.md#%5Bjava.io%2FCloseable%2Fclose%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)()  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open operator fun [equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.speechly.client.identity/BasicIdentityService///PointingToDeclaration/"></a>[BasicIdentityService](../-basic-identity-service/index.md)
| <a name="com.speechly.client.identity/CachingIdentityService///PointingToDeclaration/"></a>[CachingIdentityService](../-caching-identity-service/index.md)

