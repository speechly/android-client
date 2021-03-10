//[client](../../index.md)/[com.speechly.client.identity](../index.md)/[AuthToken](index.md)/[validate](validate.md)



# validate  
[androidJvm]  
Content  
fun [validate](validate.md)(appId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), deviceId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), expiresAt: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Validates the token against provided identifiers and expiration date. Returns true if the token is valid, false otherwise.



## Parameters  
  
androidJvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.identity/AuthToken/validate/#java.util.UUID#java.util.UUID#java.time.Instant/PointingToDeclaration/"></a>appId| <a name="com.speechly.client.identity/AuthToken/validate/#java.util.UUID#java.util.UUID#java.time.Instant/PointingToDeclaration/"></a><br><br>Speechly application ID to verify against.<br><br>
| <a name="com.speechly.client.identity/AuthToken/validate/#java.util.UUID#java.util.UUID#java.time.Instant/PointingToDeclaration/"></a>deviceId| <a name="com.speechly.client.identity/AuthToken/validate/#java.util.UUID#java.util.UUID#java.time.Instant/PointingToDeclaration/"></a><br><br>Speechly device ID to verify against.<br><br>
| <a name="com.speechly.client.identity/AuthToken/validate/#java.util.UUID#java.util.UUID#java.time.Instant/PointingToDeclaration/"></a>expiresAt| <a name="com.speechly.client.identity/AuthToken/validate/#java.util.UUID#java.util.UUID#java.time.Instant/PointingToDeclaration/"></a><br><br>timestamp to check expiration against.<br><br>
  
  



