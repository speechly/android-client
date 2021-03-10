//[client](../../index.md)/[com.speechly.client.slu](../index.md)/[SluClient](index.md)/[stream](stream.md)



# stream  
[androidJvm]  
Content  
abstract fun [stream](stream.md)(authToken: [AuthToken](../../com.speechly.client.identity/-auth-token/index.md), streamConfig: [StreamConfig](../-stream-config/index.md), audioFlow: Flow<[ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)>): [SluStream](../-slu-stream/index.md)  
More info  


Creates a new SLU stream between the client and the API.



## Parameters  
  
androidJvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.slu/SluClient/stream/#com.speechly.client.identity.AuthToken#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a>authToken| <a name="com.speechly.client.slu/SluClient/stream/#com.speechly.client.identity.AuthToken#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a><br><br>token to use for authenticating to the API.<br><br>
| <a name="com.speechly.client.slu/SluClient/stream/#com.speechly.client.identity.AuthToken#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a>streamConfig| <a name="com.speechly.client.slu/SluClient/stream/#com.speechly.client.identity.AuthToken#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a><br><br>the configuration of the SLU stream.<br><br>
  
  



