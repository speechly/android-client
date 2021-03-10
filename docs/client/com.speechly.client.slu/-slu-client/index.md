//[client](../../index.md)/[com.speechly.client.slu](../index.md)/[SluClient](index.md)



# SluClient  
 [androidJvm] interface [SluClient](index.md) : [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)

An interface representing a client for Speechly SLU API.

   


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="java.io/Closeable/close/#/PointingToDeclaration/"></a>[close](../../com.speechly.client.speech/-api-client/index.md#%5Bjava.io%2FCloseable%2Fclose%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="java.io/Closeable/close/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>abstract override fun [close](../../com.speechly.client.speech/-api-client/index.md#%5Bjava.io%2FCloseable%2Fclose%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)()  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open operator fun [equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.speechly.client.slu/SluClient/stream/#com.speechly.client.identity.AuthToken#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a>[stream](stream.md)| <a name="com.speechly.client.slu/SluClient/stream/#com.speechly.client.identity.AuthToken#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>abstract fun [stream](stream.md)(authToken: [AuthToken](../../com.speechly.client.identity/-auth-token/index.md), streamConfig: [StreamConfig](../-stream-config/index.md), audioFlow: Flow<[ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)>): [SluStream](../-slu-stream/index.md)  <br>More info  <br>Creates a new SLU stream between the client and the API.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.speechly.client.slu/GrpcSluClient///PointingToDeclaration/"></a>[GrpcSluClient](../-grpc-slu-client/index.md)

