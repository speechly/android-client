//[client](../../index.md)/[com.speechly.client.slu](../index.md)/[StreamConfig](index.md)



# StreamConfig  
 [androidJvm] data class [StreamConfig](index.md)(**channelCount**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **sampleRateHertz**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **languageCode**: [StreamConfig.LanguageCode](-language-code/index.md))

This data class represents a configuration of the audio data sent to the SLU stream. It is used for configuring the recognition backend, so its important to provide accurate values here.

   


## Parameters  
  
androidJvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.slu/StreamConfig///PointingToDeclaration/"></a>channelCount| <a name="com.speechly.client.slu/StreamConfig///PointingToDeclaration/"></a><br><br>the number of channels contained in the audio data (e.g. 1 is mono, 2 is stereo, etc.).<br><br>
| <a name="com.speechly.client.slu/StreamConfig///PointingToDeclaration/"></a>sampleRateHertz| <a name="com.speechly.client.slu/StreamConfig///PointingToDeclaration/"></a><br><br>the sample rate of the audio, in Hertz.<br><br>
| <a name="com.speechly.client.slu/StreamConfig///PointingToDeclaration/"></a>languageCode| <a name="com.speechly.client.slu/StreamConfig///PointingToDeclaration/"></a><br><br>the language of the audio, as BCP-47 compatible language tag.<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.slu/StreamConfig/StreamConfig/#kotlin.Int#kotlin.Int#com.speechly.client.slu.StreamConfig.LanguageCode/PointingToDeclaration/"></a>[StreamConfig](-stream-config.md)| <a name="com.speechly.client.slu/StreamConfig/StreamConfig/#kotlin.Int#kotlin.Int#com.speechly.client.slu.StreamConfig.LanguageCode/PointingToDeclaration/"></a> [androidJvm] fun [StreamConfig](-stream-config.md)(channelCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), sampleRateHertz: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), languageCode: [StreamConfig.LanguageCode](-language-code/index.md))the number of channels contained in the audio data (e.g.   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.slu/StreamConfig.LanguageCode///PointingToDeclaration/"></a>[LanguageCode](-language-code/index.md)| <a name="com.speechly.client.slu/StreamConfig.LanguageCode///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>enum [LanguageCode](-language-code/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[StreamConfig.LanguageCode](-language-code/index.md)>   <br>More info  <br>This enum class represents audio languages supported by the SLU API.  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.slu/StreamConfig/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.speechly.client.slu/StreamConfig/component1/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>operator fun [component1](component1.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.speechly.client.slu/StreamConfig/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.speechly.client.slu/StreamConfig/component2/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.speechly.client.slu/StreamConfig/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="com.speechly.client.slu/StreamConfig/component3/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>operator fun [component3](component3.md)(): [StreamConfig.LanguageCode](-language-code/index.md)  <br><br><br>
| <a name="com.speechly.client.slu/StreamConfig/copy/#kotlin.Int#kotlin.Int#com.speechly.client.slu.StreamConfig.LanguageCode/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.speechly.client.slu/StreamConfig/copy/#kotlin.Int#kotlin.Int#com.speechly.client.slu.StreamConfig.LanguageCode/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [copy](copy.md)(channelCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), sampleRateHertz: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), languageCode: [StreamConfig.LanguageCode](-language-code/index.md)): [StreamConfig](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open operator override fun [equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.slu/StreamConfig/channelCount/#/PointingToDeclaration/"></a>[channelCount](channel-count.md)| <a name="com.speechly.client.slu/StreamConfig/channelCount/#/PointingToDeclaration/"></a> [androidJvm] val [channelCount](channel-count.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)the number of channels contained in the audio data (e.g.   <br>
| <a name="com.speechly.client.slu/StreamConfig/languageCode/#/PointingToDeclaration/"></a>[languageCode](language-code.md)| <a name="com.speechly.client.slu/StreamConfig/languageCode/#/PointingToDeclaration/"></a> [androidJvm] val [languageCode](language-code.md): [StreamConfig.LanguageCode](-language-code/index.md)the language of the audio, as BCP-47 compatible language tag.   <br>
| <a name="com.speechly.client.slu/StreamConfig/sampleRateHertz/#/PointingToDeclaration/"></a>[sampleRateHertz](sample-rate-hertz.md)| <a name="com.speechly.client.slu/StreamConfig/sampleRateHertz/#/PointingToDeclaration/"></a> [androidJvm] val [sampleRateHertz](sample-rate-hertz.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)the sample rate of the audio, in Hertz.   <br>

