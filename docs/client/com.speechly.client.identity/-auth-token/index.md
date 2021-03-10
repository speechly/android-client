//[client](../../index.md)/[com.speechly.client.identity](../index.md)/[AuthToken](index.md)



# AuthToken  
 [androidJvm] data class [AuthToken](index.md)(**appId**: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), **deviceId**: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), **expiresAt**: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html), **authScopes**: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[AuthToken.AuthScope](-auth-scope/index.md)>, **tokenString**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

This data class represents an authentication token that can be used to access public Speechly API. The token is usually obtained from Speechly Identity Service and can be cached for its expiration period.

   


## Parameters  
  
androidJvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.identity/AuthToken///PointingToDeclaration/"></a>appId| <a name="com.speechly.client.identity/AuthToken///PointingToDeclaration/"></a><br><br>the ID of Speechly application that will be accessed with this token.<br><br>
| <a name="com.speechly.client.identity/AuthToken///PointingToDeclaration/"></a>deviceId| <a name="com.speechly.client.identity/AuthToken///PointingToDeclaration/"></a><br><br>Speechly device identifier that is authorised to use this token.<br><br>
| <a name="com.speechly.client.identity/AuthToken///PointingToDeclaration/"></a>expiresAt| <a name="com.speechly.client.identity/AuthToken///PointingToDeclaration/"></a><br><br>the timestamp of token expiration.<br><br>
| <a name="com.speechly.client.identity/AuthToken///PointingToDeclaration/"></a>authScopes| <a name="com.speechly.client.identity/AuthToken///PointingToDeclaration/"></a><br><br>Speechly APIs that can be accessed with this token.<br><br>
| <a name="com.speechly.client.identity/AuthToken///PointingToDeclaration/"></a>tokenString| <a name="com.speechly.client.identity/AuthToken///PointingToDeclaration/"></a><br><br>the token value that should be passed to API when accessing it.<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.identity/AuthToken/AuthToken/#java.util.UUID#java.util.UUID#java.time.Instant#kotlin.collections.Set[com.speechly.client.identity.AuthToken.AuthScope]#kotlin.String/PointingToDeclaration/"></a>[AuthToken](-auth-token.md)| <a name="com.speechly.client.identity/AuthToken/AuthToken/#java.util.UUID#java.util.UUID#java.time.Instant#kotlin.collections.Set[com.speechly.client.identity.AuthToken.AuthScope]#kotlin.String/PointingToDeclaration/"></a> [androidJvm] fun [AuthToken](-auth-token.md)(appId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), deviceId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), expiresAt: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html), authScopes: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[AuthToken.AuthScope](-auth-scope/index.md)>, tokenString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))the ID of Speechly application that will be accessed with this token.   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.identity/AuthToken.AuthScope///PointingToDeclaration/"></a>[AuthScope](-auth-scope/index.md)| <a name="com.speechly.client.identity/AuthToken.AuthScope///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>enum [AuthScope](-auth-scope/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[AuthToken.AuthScope](-auth-scope/index.md)>   <br>More info  <br>This enum class represents known Speechly APIs scopes which are returned in the token payload.  <br><br><br>
| <a name="com.speechly.client.identity/AuthToken.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.speechly.client.identity/AuthToken.Companion///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.identity/AuthToken/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.speechly.client.identity/AuthToken/component1/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>operator fun [component1](component1.md)(): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)  <br><br><br>
| <a name="com.speechly.client.identity/AuthToken/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.speechly.client.identity/AuthToken/component2/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>operator fun [component2](component2.md)(): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)  <br><br><br>
| <a name="com.speechly.client.identity/AuthToken/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="com.speechly.client.identity/AuthToken/component3/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>operator fun [component3](component3.md)(): [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)  <br><br><br>
| <a name="com.speechly.client.identity/AuthToken/component4/#/PointingToDeclaration/"></a>[component4](component4.md)| <a name="com.speechly.client.identity/AuthToken/component4/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>operator fun [component4](component4.md)(): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[AuthToken.AuthScope](-auth-scope/index.md)>  <br><br><br>
| <a name="com.speechly.client.identity/AuthToken/component5/#/PointingToDeclaration/"></a>[component5](component5.md)| <a name="com.speechly.client.identity/AuthToken/component5/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>operator fun [component5](component5.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="com.speechly.client.identity/AuthToken/copy/#java.util.UUID#java.util.UUID#java.time.Instant#kotlin.collections.Set[com.speechly.client.identity.AuthToken.AuthScope]#kotlin.String/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.speechly.client.identity/AuthToken/copy/#java.util.UUID#java.util.UUID#java.time.Instant#kotlin.collections.Set[com.speechly.client.identity.AuthToken.AuthScope]#kotlin.String/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [copy](copy.md)(appId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), deviceId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), expiresAt: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html), authScopes: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[AuthToken.AuthScope](-auth-scope/index.md)>, tokenString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [AuthToken](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open operator override fun [equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="com.speechly.client.identity/AuthToken/validate/#java.util.UUID#java.util.UUID#java.time.Instant/PointingToDeclaration/"></a>[validate](validate.md)| <a name="com.speechly.client.identity/AuthToken/validate/#java.util.UUID#java.util.UUID#java.time.Instant/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [validate](validate.md)(appId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), deviceId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), expiresAt: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Validates the token against provided identifiers and expiration date.  <br><br><br>
| <a name="com.speechly.client.identity/AuthToken/validateExpiry/#java.time.Instant/PointingToDeclaration/"></a>[validateExpiry](validate-expiry.md)| <a name="com.speechly.client.identity/AuthToken/validateExpiry/#java.time.Instant/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [validateExpiry](validate-expiry.md)(expiresAt: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Validates the expiry of the token against provided timestamp.  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.identity/AuthToken/appId/#/PointingToDeclaration/"></a>[appId](app-id.md)| <a name="com.speechly.client.identity/AuthToken/appId/#/PointingToDeclaration/"></a> [androidJvm] val [appId](app-id.md): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)the ID of Speechly application that will be accessed with this token.   <br>
| <a name="com.speechly.client.identity/AuthToken/authScopes/#/PointingToDeclaration/"></a>[authScopes](auth-scopes.md)| <a name="com.speechly.client.identity/AuthToken/authScopes/#/PointingToDeclaration/"></a> [androidJvm] val [authScopes](auth-scopes.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[AuthToken.AuthScope](-auth-scope/index.md)>Speechly APIs that can be accessed with this token.   <br>
| <a name="com.speechly.client.identity/AuthToken/deviceId/#/PointingToDeclaration/"></a>[deviceId](device-id.md)| <a name="com.speechly.client.identity/AuthToken/deviceId/#/PointingToDeclaration/"></a> [androidJvm] val [deviceId](device-id.md): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)Speechly device identifier that is authorised to use this token.   <br>
| <a name="com.speechly.client.identity/AuthToken/expiresAt/#/PointingToDeclaration/"></a>[expiresAt](expires-at.md)| <a name="com.speechly.client.identity/AuthToken/expiresAt/#/PointingToDeclaration/"></a> [androidJvm] val [expiresAt](expires-at.md): [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)the timestamp of token expiration.   <br>
| <a name="com.speechly.client.identity/AuthToken/tokenString/#/PointingToDeclaration/"></a>[tokenString](token-string.md)| <a name="com.speechly.client.identity/AuthToken/tokenString/#/PointingToDeclaration/"></a> [androidJvm] val [tokenString](token-string.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)the token value that should be passed to API when accessing it.   <br>

