//[client](../../index.md)/[com.speechly.client.identity](../index.md)/[GrpcIdentityClient](index.md)



# GrpcIdentityClient  
 [androidJvm] class [GrpcIdentityClient](index.md)(**channel**: ManagedChannel, **shutdownTimeout**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [IdentityClient](../-identity-client/index.md)

A client for Speechly gRPC Identity API.

   


## Parameters  
  
androidJvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.identity/GrpcIdentityClient///PointingToDeclaration/"></a>channel| <a name="com.speechly.client.identity/GrpcIdentityClient///PointingToDeclaration/"></a><br><br>the gRPC channel to use for sending requests to the API<br><br>
| <a name="com.speechly.client.identity/GrpcIdentityClient///PointingToDeclaration/"></a>shutdownTimeout| <a name="com.speechly.client.identity/GrpcIdentityClient///PointingToDeclaration/"></a><br><br>the timeout for closing the gRPC channel<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.identity/GrpcIdentityClient/GrpcIdentityClient/#io.grpc.ManagedChannel#kotlin.Long/PointingToDeclaration/"></a>[GrpcIdentityClient](-grpc-identity-client.md)| <a name="com.speechly.client.identity/GrpcIdentityClient/GrpcIdentityClient/#io.grpc.ManagedChannel#kotlin.Long/PointingToDeclaration/"></a> [androidJvm] fun [GrpcIdentityClient](-grpc-identity-client.md)(channel: ManagedChannel, shutdownTimeout: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 5)the gRPC channel to use for sending requests to the API   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.identity/GrpcIdentityClient.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.speechly.client.identity/GrpcIdentityClient.Companion///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.identity/GrpcIdentityClient/close/#/PointingToDeclaration/"></a>[close](close.md)| <a name="com.speechly.client.identity/GrpcIdentityClient/close/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [close](close.md)()  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open operator fun [equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.speechly.client.identity/GrpcIdentityClient/login/#com.speechly.api.identity.v1.IdentityOuterClass.LoginRequest/PointingToDeclaration/"></a>[login](login.md)| <a name="com.speechly.client.identity/GrpcIdentityClient/login/#com.speechly.api.identity.v1.IdentityOuterClass.LoginRequest/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open suspend override fun [login](login.md)(request: IdentityOuterClass.LoginRequest): IdentityOuterClass.LoginResponse  <br>More info  <br>Performs a login against the API using provided request.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

