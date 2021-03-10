//[client](../index.md)/[com.speechly.client.speech](index.md)



# Package com.speechly.client.speech  


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.speech/ApiClient///PointingToDeclaration/"></a>[ApiClient](-api-client/index.md)| <a name="com.speechly.client.speech/ApiClient///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>interface [ApiClient](-api-client/index.md) : [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)  <br>More info  <br>A client for Speechly Spoken Language Understanding (SLU) API.  <br><br><br>
| <a name="com.speechly.client.speech/AudioRecorder///PointingToDeclaration/"></a>[AudioRecorder](-audio-recorder/index.md)| <a name="com.speechly.client.speech/AudioRecorder///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>class [AudioRecorder](-audio-recorder/index.md)(**activity**: [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), **sampleRate**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))  <br><br><br>
| <a name="com.speechly.client.speech/Client///PointingToDeclaration/"></a>[Client](-client/index.md)| <a name="com.speechly.client.speech/Client///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>class [Client](-client/index.md)(**appId**: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), **language**: [StreamConfig.LanguageCode](../com.speechly.client.slu/-stream-config/-language-code/index.md), **deviceIdProvider**: [DeviceIdProvider](../com.speechly.client.device/-device-id-provider/index.md), **identityService**: [IdentityService](../com.speechly.client.identity/-identity-service/index.md), **sluClient**: [GrpcSluClient](../com.speechly.client.slu/-grpc-slu-client/index.md), **audioRecorder**: [AudioRecorder](-audio-recorder/index.md), **activity**: [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html)) : [ApiClient](-api-client/index.md)  <br><br><br>
| <a name="com.speechly.client.speech/NoActiveStreamException///PointingToDeclaration/"></a>[NoActiveStreamException](-no-active-stream-exception/index.md)| <a name="com.speechly.client.speech/NoActiveStreamException///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>class [NoActiveStreamException](-no-active-stream-exception/index.md) : [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)  <br>More info  <br>This class represents an exception indicating that there is no active stream to interact with.  <br><br><br>

