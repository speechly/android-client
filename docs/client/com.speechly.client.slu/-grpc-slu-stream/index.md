//[client](../../index.md)/[com.speechly.client.slu](../index.md)/[GrpcSluStream](index.md)



# GrpcSluStream  
 [androidJvm] @ExperimentalCoroutinesApi()  
  
class [GrpcSluStream](index.md)(**clientStub**: SLUGrpcKt.SLUCoroutineStub, **streamConfig**: [StreamConfig](../-stream-config/index.md), **audioFlow**: Flow<[ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)>) : [SluStream](../-slu-stream/index.md)

A SLU stream implementation backed by Speechly gRPC SLU API.

   


## Parameters  
  
androidJvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.slu/GrpcSluStream///PointingToDeclaration/"></a>clientStub| <a name="com.speechly.client.slu/GrpcSluStream///PointingToDeclaration/"></a><br><br>client stub for the API, with metadata attached.<br><br>
| <a name="com.speechly.client.slu/GrpcSluStream///PointingToDeclaration/"></a>streamConfig| <a name="com.speechly.client.slu/GrpcSluStream///PointingToDeclaration/"></a><br><br>SLU configuration to use for this stream.<br><br>
| <a name="com.speechly.client.slu/GrpcSluStream///PointingToDeclaration/"></a>requestChannel| <a name="com.speechly.client.slu/GrpcSluStream///PointingToDeclaration/"></a><br><br>(optional) channel to use for sending the audio chunks.<br><br>
| <a name="com.speechly.client.slu/GrpcSluStream///PointingToDeclaration/"></a>responseChannel| <a name="com.speechly.client.slu/GrpcSluStream///PointingToDeclaration/"></a><br><br>(optional) channel to use for receiving responses.<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.slu/GrpcSluStream/GrpcSluStream/#com.speechly.api.slu.v1.SLUGrpcKt.SLUCoroutineStub#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a>[GrpcSluStream](-grpc-slu-stream.md)| <a name="com.speechly.client.slu/GrpcSluStream/GrpcSluStream/#com.speechly.api.slu.v1.SLUGrpcKt.SLUCoroutineStub#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a> [androidJvm] fun [GrpcSluStream](-grpc-slu-stream.md)(clientStub: SLUGrpcKt.SLUCoroutineStub, streamConfig: [StreamConfig](../-stream-config/index.md), audioFlow: Flow<[ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)>)client stub for the API, with metadata attached.   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.slu/GrpcSluStream/close/#/PointingToDeclaration/"></a>[close](close.md)| <a name="com.speechly.client.slu/GrpcSluStream/close/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>@ExperimentalCoroutinesApi()  <br>  <br>open override fun [close](close.md)()  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open operator fun [equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-752291050)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.slu/GrpcSluStream/responseFlow/#/PointingToDeclaration/"></a>[responseFlow](response-flow.md)| <a name="com.speechly.client.slu/GrpcSluStream/responseFlow/#/PointingToDeclaration/"></a> [androidJvm] var [responseFlow](response-flow.md): Flow<Slu.SLUResponse>? = null   <br>

