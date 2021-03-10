//[client](../../index.md)/[com.speechly.client.identity](../index.md)/[AuthToken](index.md)/[AuthToken](-auth-token.md)



# AuthToken  
[androidJvm]  
Content  
fun [AuthToken](-auth-token.md)(appId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), deviceId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), expiresAt: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html), authScopes: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[AuthToken.AuthScope](-auth-scope/index.md)>, tokenString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))  
More info  


## Parameters  
  
androidJvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.identity/AuthToken/AuthToken/#java.util.UUID#java.util.UUID#java.time.Instant#kotlin.collections.Set[com.speechly.client.identity.AuthToken.AuthScope]#kotlin.String/PointingToDeclaration/"></a>appId| <a name="com.speechly.client.identity/AuthToken/AuthToken/#java.util.UUID#java.util.UUID#java.time.Instant#kotlin.collections.Set[com.speechly.client.identity.AuthToken.AuthScope]#kotlin.String/PointingToDeclaration/"></a><br><br>the ID of Speechly application that will be accessed with this token.<br><br>
| <a name="com.speechly.client.identity/AuthToken/AuthToken/#java.util.UUID#java.util.UUID#java.time.Instant#kotlin.collections.Set[com.speechly.client.identity.AuthToken.AuthScope]#kotlin.String/PointingToDeclaration/"></a>deviceId| <a name="com.speechly.client.identity/AuthToken/AuthToken/#java.util.UUID#java.util.UUID#java.time.Instant#kotlin.collections.Set[com.speechly.client.identity.AuthToken.AuthScope]#kotlin.String/PointingToDeclaration/"></a><br><br>Speechly device identifier that is authorised to use this token.<br><br>
| <a name="com.speechly.client.identity/AuthToken/AuthToken/#java.util.UUID#java.util.UUID#java.time.Instant#kotlin.collections.Set[com.speechly.client.identity.AuthToken.AuthScope]#kotlin.String/PointingToDeclaration/"></a>expiresAt| <a name="com.speechly.client.identity/AuthToken/AuthToken/#java.util.UUID#java.util.UUID#java.time.Instant#kotlin.collections.Set[com.speechly.client.identity.AuthToken.AuthScope]#kotlin.String/PointingToDeclaration/"></a><br><br>the timestamp of token expiration.<br><br>
| <a name="com.speechly.client.identity/AuthToken/AuthToken/#java.util.UUID#java.util.UUID#java.time.Instant#kotlin.collections.Set[com.speechly.client.identity.AuthToken.AuthScope]#kotlin.String/PointingToDeclaration/"></a>authScopes| <a name="com.speechly.client.identity/AuthToken/AuthToken/#java.util.UUID#java.util.UUID#java.time.Instant#kotlin.collections.Set[com.speechly.client.identity.AuthToken.AuthScope]#kotlin.String/PointingToDeclaration/"></a><br><br>Speechly APIs that can be accessed with this token.<br><br>
| <a name="com.speechly.client.identity/AuthToken/AuthToken/#java.util.UUID#java.util.UUID#java.time.Instant#kotlin.collections.Set[com.speechly.client.identity.AuthToken.AuthScope]#kotlin.String/PointingToDeclaration/"></a>tokenString| <a name="com.speechly.client.identity/AuthToken/AuthToken/#java.util.UUID#java.util.UUID#java.time.Instant#kotlin.collections.Set[com.speechly.client.identity.AuthToken.AuthScope]#kotlin.String/PointingToDeclaration/"></a><br><br>the token value that should be passed to API when accessing it.<br><br>
  
  



