//[client](../../index.md)/[com.speechly.client.slu](../index.md)/[GrpcSluClient](index.md)



# GrpcSluClient  
 [androidJvm] class [GrpcSluClient](index.md)(**channel**: ManagedChannel, **shutdownTimeout**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [SluClient](../-slu-client/index.md)

A client for Speechly gRPC SLU API.

   


## Parameters  
  
androidJvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.slu/GrpcSluClient///PointingToDeclaration/"></a>channel| <a name="com.speechly.client.slu/GrpcSluClient///PointingToDeclaration/"></a><br><br>the gRPC channel to use for sending requests to the API<br><br>
| <a name="com.speechly.client.slu/GrpcSluClient///PointingToDeclaration/"></a>shutdownTimeout| <a name="com.speechly.client.slu/GrpcSluClient///PointingToDeclaration/"></a><br><br>the timeout for closing the gRPC channel<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.slu/GrpcSluClient/GrpcSluClient/#io.grpc.ManagedChannel#kotlin.Long/PointingToDeclaration/"></a>[GrpcSluClient](-grpc-slu-client.md)| <a name="com.speechly.client.slu/GrpcSluClient/GrpcSluClient/#io.grpc.ManagedChannel#kotlin.Long/PointingToDeclaration/"></a> [androidJvm] fun [GrpcSluClient](-grpc-slu-client.md)(channel: ManagedChannel, shutdownTimeout: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 5)the gRPC channel to use for sending requests to the API   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.slu/GrpcSluClient.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.speechly.client.slu/GrpcSluClient.Companion///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.slu/GrpcSluClient/close/#/PointingToDeclaration/"></a>[close](close.md)| <a name="com.speechly.client.slu/GrpcSluClient/close/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [close](close.md)()  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open operator fun [equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.speechly.client.slu/GrpcSluClient/stream/#com.speechly.client.identity.AuthToken#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a>[stream](stream.md)| <a name="com.speechly.client.slu/GrpcSluClient/stream/#com.speechly.client.identity.AuthToken#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>@ExperimentalCoroutinesApi()  <br>  <br>open override fun [stream](stream.md)(authToken: [AuthToken](../../com.speechly.client.identity/-auth-token/index.md), streamConfig: [StreamConfig](../-stream-config/index.md), audioFlow: Flow<[ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)>): [GrpcSluStream](../-grpc-slu-stream/index.md)  <br>More info  <br>Creates a new SLU stream between the client and the API.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

