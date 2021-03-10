//[client](../../index.md)/[com.speechly.client.slu](../index.md)/[Segment](index.md)



# Segment  
 [androidJvm] class [Segment](index.md)(**contextId**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **segmentId**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))

The smallest component of SLU API, defined by an intent.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.slu/Segment/Segment/#kotlin.String#kotlin.Int/PointingToDeclaration/"></a>[Segment](-segment.md)| <a name="com.speechly.client.slu/Segment/Segment/#kotlin.String#kotlin.Int/PointingToDeclaration/"></a> [androidJvm] fun [Segment](-segment.md)(contextId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), segmentId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open operator fun [equals](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="com.speechly.client.slu/Segment/finalize/#/PointingToDeclaration/"></a>[finalize](finalize.md)| <a name="com.speechly.client.slu/Segment/finalize/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [finalize](finalize.md)()  <br><br><br>
| <a name="com.speechly.client.slu/Segment/getEntityByType/#kotlin.String/PointingToDeclaration/"></a>[getEntityByType](get-entity-by-type.md)| <a name="com.speechly.client.slu/Segment/getEntityByType/#kotlin.String/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [getEntityByType](get-entity-by-type.md)(type: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Entity](../-entity/index.md)?  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [hashCode](../../com.speechly.ui/-speechly-button/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [toString](../../com.speechly.client.speech/-client/-companion/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-126307046)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="com.speechly.client.slu/Segment/updateEntities/#kotlin.collections.MutableList[com.speechly.client.slu.Entity]/PointingToDeclaration/"></a>[updateEntities](update-entities.md)| <a name="com.speechly.client.slu/Segment/updateEntities/#kotlin.collections.MutableList[com.speechly.client.slu.Entity]/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [updateEntities](update-entities.md)(entities: [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)<[Entity](../-entity/index.md)>)  <br><br><br>
| <a name="com.speechly.client.slu/Segment/updateEntity/#com.speechly.client.slu.Entity/PointingToDeclaration/"></a>[updateEntity](update-entity.md)| <a name="com.speechly.client.slu/Segment/updateEntity/#com.speechly.client.slu.Entity/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [updateEntity](update-entity.md)(entity: [Entity](../-entity/index.md))  <br><br><br>
| <a name="com.speechly.client.slu/Segment/updateIntent/#com.speechly.client.slu.Intent/PointingToDeclaration/"></a>[updateIntent](update-intent.md)| <a name="com.speechly.client.slu/Segment/updateIntent/#com.speechly.client.slu.Intent/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [updateIntent](update-intent.md)(intent: [Intent](../-intent/index.md))  <br><br><br>
| <a name="com.speechly.client.slu/Segment/updateTranscript/#com.speechly.client.slu.Word/PointingToDeclaration/"></a>[updateTranscript](update-transcript.md)| <a name="com.speechly.client.slu/Segment/updateTranscript/#com.speechly.client.slu.Word/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [updateTranscript](update-transcript.md)(word: [Word](../-word/index.md))  <br><br><br>
| <a name="com.speechly.client.slu/Segment/updateTranscripts/#kotlin.collections.MutableList[com.speechly.client.slu.Transcript]/PointingToDeclaration/"></a>[updateTranscripts](update-transcripts.md)| <a name="com.speechly.client.slu/Segment/updateTranscripts/#kotlin.collections.MutableList[com.speechly.client.slu.Transcript]/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [updateTranscripts](update-transcripts.md)(transcripts: [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)<[Transcript](../-transcript/index.md)>)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.speechly.client.slu/Segment/contextId/#/PointingToDeclaration/"></a>[contextId](context-id.md)| <a name="com.speechly.client.slu/Segment/contextId/#/PointingToDeclaration/"></a> [androidJvm] val [contextId](context-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)   <br>
| <a name="com.speechly.client.slu/Segment/entities/#/PointingToDeclaration/"></a>[entities](entities.md)| <a name="com.speechly.client.slu/Segment/entities/#/PointingToDeclaration/"></a> [androidJvm] var [entities](entities.md): [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Entity](../-entity/index.md)>   <br>
| <a name="com.speechly.client.slu/Segment/intent/#/PointingToDeclaration/"></a>[intent](intent.md)| <a name="com.speechly.client.slu/Segment/intent/#/PointingToDeclaration/"></a> [androidJvm] var [intent](intent.md): [Intent](../-intent/index.md)? = null   <br>
| <a name="com.speechly.client.slu/Segment/isFinal/#/PointingToDeclaration/"></a>[isFinal](is-final.md)| <a name="com.speechly.client.slu/Segment/isFinal/#/PointingToDeclaration/"></a> [androidJvm] var [isFinal](is-final.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false   <br>
| <a name="com.speechly.client.slu/Segment/segmentId/#/PointingToDeclaration/"></a>[segmentId](segment-id.md)| <a name="com.speechly.client.slu/Segment/segmentId/#/PointingToDeclaration/"></a> [androidJvm] val [segmentId](segment-id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>
| <a name="com.speechly.client.slu/Segment/words/#/PointingToDeclaration/"></a>[words](words.md)| <a name="com.speechly.client.slu/Segment/words/#/PointingToDeclaration/"></a> [androidJvm] var [words](words.md): [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Word](../-word/index.md)>   <br>

