<div align="center" markdown="1">
<a href="https://www.speechly.com">
   <img src="https://d33wubrfki0l68.cloudfront.net/f15fc952956e1952d6bd23661b7a7ee6b775faaa/c1b30/img/speechly-logo-duo-black.svg" height="48" />
</a>

### Real-time automatic speech recognition and natural language understanding tools in one flexible API

[Website](https://www.speechly.com/)
&ensp;|&ensp;
[Docs](https://docs.speechly.com/)
&ensp;|&ensp;
[Discussions](https://github.com/speechly/speechly/discussions)
&ensp;|&ensp;
[Blog](https://www.speechly.com/blog/)
&ensp;|&ensp;
[Podcast](https://anchor.fm/the-speechly-podcast)

---
</div>

# Android client for Speechly SLU API

[![License](http://img.shields.io/:license-mit-blue.svg)](LICENSE)

This repository contains the source code for the Android client for [Speechly](https://www.speechly.com/?utm_source=github&utm_medium=android-client&utm_campaign=text) SLU API. Speechly allows you to easily build applications with voice-enabled UIs.

### Requirements

* Android 8.0 (API level 26) and above
* Android Emulator version must be >= 30.4.5

## Usage

### Configuration

Add android-client to your build.gradle dependencies.

```gradle
dependencies {
  implementation 'com.speechly:android-client:0.1.11'
}
```

Remember to add permissions for microphone input and network connections as well as audio stream sampling in `AndroidManifest.xml`:

```xml
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.RECORD_AUDIO"/>
    <uses-permission android:name="android.permission.MODIFY_AUDIO_SETTINGS"/>
```




### Client usage

Create a client, usable for the total lifetime of the app:

```kotlin
val speechlyClient: Client = Client.fromActivity(activity = this, UUID.fromString("your APP_ID"))

```

Then, create a button which handles the opening and closing of the microphone:


```kotlin

var button: SpeechlyButton = findViewById(R.id.speechly)

var buttonTouchListener = object : View.OnTouchListener {
        override fun onTouch(v: View?, event: MotionEvent?): Boolean {
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    speechlyClient.startContext()
                }
                MotionEvent.ACTION_UP -> {
                    speechlyClient.stopContext()
                }
            }
            return true
        }
    }

button.setOnTouchListener(buttonTouchListener)
```

The final thing is to react to the events the API sends back:

```kotlin
speechlyClient.onSegmentChange { segment: Segment ->
    val transcript: String = segment.words.values.map{it.value}.joinToString(" ")
    print(transcript)
}

```

Check out the [example repo filtering app](https://github.com/speechly/android-repo-filtering) for a demo app built using this client.

## Documentation

You can find the detailed API documentation in [GitHub repository](https://github.com/speechly/android-client/blob/main/docs/client/README.md).

Also, the [web client tutorial](https://docs.speechly.com/tutorials/web-client/) contains a similar event driven client as we have here.

## About Speechly

Speechly is a developer tool for building real-time multimodal voice user interfaces. It enables developers and designers to enhance their current touch user interface with voice functionalities for better user experience. Speechly key features:

#### Speechly key features

- Fully streaming API
- Multi modal from the ground up
- Easy to configure for any use case
- Fast to integrate to any touch screen application
- Supports natural corrections such as "Show me red – i mean blue t-shirts"
- Real time visual feedback encourages users to go on with their voice
