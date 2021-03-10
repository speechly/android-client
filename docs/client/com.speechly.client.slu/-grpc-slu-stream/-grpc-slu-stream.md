//[client](../../index.md)/[com.speechly.client.slu](../index.md)/[GrpcSluStream](index.md)/[GrpcSluStream](-grpc-slu-stream.md)



# GrpcSluStream  
[androidJvm]  
Content  
fun [GrpcSluStream](-grpc-slu-stream.md)(clientStub: SLUGrpcKt.SLUCoroutineStub, streamConfig: [StreamConfig](../-stream-config/index.md), audioFlow: Flow<[ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)>)  
More info  


## Parameters  
  
androidJvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.slu/GrpcSluStream/GrpcSluStream/#com.speechly.api.slu.v1.SLUGrpcKt.SLUCoroutineStub#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a>clientStub| <a name="com.speechly.client.slu/GrpcSluStream/GrpcSluStream/#com.speechly.api.slu.v1.SLUGrpcKt.SLUCoroutineStub#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a><br><br>client stub for the API, with metadata attached.<br><br>
| <a name="com.speechly.client.slu/GrpcSluStream/GrpcSluStream/#com.speechly.api.slu.v1.SLUGrpcKt.SLUCoroutineStub#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a>streamConfig| <a name="com.speechly.client.slu/GrpcSluStream/GrpcSluStream/#com.speechly.api.slu.v1.SLUGrpcKt.SLUCoroutineStub#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a><br><br>SLU configuration to use for this stream.<br><br>
| <a name="com.speechly.client.slu/GrpcSluStream/GrpcSluStream/#com.speechly.api.slu.v1.SLUGrpcKt.SLUCoroutineStub#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a>requestChannel| <a name="com.speechly.client.slu/GrpcSluStream/GrpcSluStream/#com.speechly.api.slu.v1.SLUGrpcKt.SLUCoroutineStub#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a><br><br>(optional) channel to use for sending the audio chunks.<br><br>
| <a name="com.speechly.client.slu/GrpcSluStream/GrpcSluStream/#com.speechly.api.slu.v1.SLUGrpcKt.SLUCoroutineStub#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a>responseChannel| <a name="com.speechly.client.slu/GrpcSluStream/GrpcSluStream/#com.speechly.api.slu.v1.SLUGrpcKt.SLUCoroutineStub#com.speechly.client.slu.StreamConfig#kotlinx.coroutines.flow.Flow[kotlin.ByteArray]/PointingToDeclaration/"></a><br><br>(optional) channel to use for receiving responses.<br><br>
  
  



