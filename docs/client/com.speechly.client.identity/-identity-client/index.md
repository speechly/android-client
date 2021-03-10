//[client](../../index.md)/[com.speechly.client.identity](../index.md)/[IdentityClient](index.md)



# IdentityClient  
 [androidJvm] interface [IdentityClient](index.md) : [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)

An interface representing a client for Speechly Identity API.

   


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="java.io/Closeable/close/#/PointingToDeclaration/"></a>[close](../../com.speechly.client.speech/-api-client/index.md#%5Bjava.io%2FCloseable%2Fclose%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)| <a name="java.io/Closeable/close/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>abstract override fun [close](../../com.speechly.client.speech/-api-client/index.md#%5Bjava.io%2FCloseable%2Fclose%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)()  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open operator fun [equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.speechly.client.identity/IdentityClient/login/#com.speechly.api.identity.v1.IdentityOuterClass.LoginRequest/PointingToDeclaration/"></a>[login](login.md)| <a name="com.speechly.client.identity/IdentityClient/login/#com.speechly.api.identity.v1.IdentityOuterClass.LoginRequest/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>abstract suspend fun [login](login.md)(request: IdentityOuterClass.LoginRequest): IdentityOuterClass.LoginResponse  <br>More info  <br>Performs a login against the API using provided request.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.speechly.client.identity/GrpcIdentityClient///PointingToDeclaration/"></a>[GrpcIdentityClient](../-grpc-identity-client/index.md)

