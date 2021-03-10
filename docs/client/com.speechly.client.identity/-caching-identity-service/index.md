//[client](../../index.md)/[com.speechly.client.identity](../index.md)/[CachingIdentityService](index.md)



# CachingIdentityService  
 [androidJvm] class [CachingIdentityService](index.md)(**baseService**: [IdentityService](../-identity-service/index.md)) : [IdentityService](../-identity-service/index.md)

Implements the IdentityService interface by fetching the tokens from the base service implementation and using a persistent cache to store them for future use.

   


## Parameters  
  
androidJvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.identity/CachingIdentityService///PointingToDeclaration/"></a>baseService| <a name="com.speechly.client.identity/CachingIdentityService///PointingToDeclaration/"></a><br><br>an IdentityService implementation used for fetching tokens in case of cache miss<br><br>
| <a name="com.speechly.client.identity/CachingIdentityService///PointingToDeclaration/"></a>cacheService| <a name="com.speechly.client.identity/CachingIdentityService///PointingToDeclaration/"></a><br><br>an implementation of PersistentCache that is used for storing cached tokens<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.identity/CachingIdentityService/CachingIdentityService/#com.speechly.client.identity.IdentityService/PointingToDeclaration/"></a>[CachingIdentityService](-caching-identity-service.md)| <a name="com.speechly.client.identity/CachingIdentityService/CachingIdentityService/#com.speechly.client.identity.IdentityService/PointingToDeclaration/"></a> [androidJvm] fun [CachingIdentityService](-caching-identity-service.md)(baseService: [IdentityService](../-identity-service/index.md))an IdentityService implementation used for fetching tokens in case of cache miss   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.identity/CachingIdentityService.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.speechly.client.identity/CachingIdentityService.Companion///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.identity/CachingIdentityService/authenticate/#java.util.UUID#java.util.UUID/PointingToDeclaration/"></a>[authenticate](authenticate.md)| <a name="com.speechly.client.identity/CachingIdentityService/authenticate/#java.util.UUID#java.util.UUID/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open suspend override fun [authenticate](authenticate.md)(appId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), deviceId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)): [AuthToken](../-auth-token/index.md)  <br>More info  <br>Fetches a new authentication token and decodes it into AuthToken.  <br><br><br>
| <a name="com.speechly.client.identity/CachingIdentityService/close/#/PointingToDeclaration/"></a>[close](close.md)| <a name="com.speechly.client.identity/CachingIdentityService/close/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [close](close.md)()  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open operator fun [equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.identity/CachingIdentityService/cacheService/#/PointingToDeclaration/"></a>[cacheService](cache-service.md)| <a name="com.speechly.client.identity/CachingIdentityService/cacheService/#/PointingToDeclaration/"></a> [androidJvm] var [cacheService](cache-service.md): [CacheService](../../com.speechly.client.cache/-cache-service/index.md)? = null   <br>

