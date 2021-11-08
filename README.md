<div align="center" markdown="1">
<a href="https://www.speechly.com/?utm_source=github&utm_medium=browser-client&utm_campaign=header">
   <img src="https://d33wubrfki0l68.cloudfront.net/1e70457a60b0627de6ab966f1e0a40cf56f465f5/b4144/img/logo-speechly-colors.svg" height="48">
</a>

### Speechly is the Fast, Accurate, and Simple Voice Interface API for Web, Mobile and E‑commerce

[Website](https://www.speechly.com/?utm_source=github&utm_medium=browser-client&utm_campaign=header)
&ensp;|&ensp;
[Docs](https://docs.speechly.com/)
&ensp;|&ensp;
[Discussions](https://github.com/speechly/speechly/discussions)
&ensp;|&ensp;
[Blog](https://www.speechly.com/blog/?utm_source=github&utm_medium=browser-client&utm_campaign=header)
&ensp;|&ensp;
[Podcast](https://anchor.fm/collin-borns/episodes/The-Speechly-Podcast---Introduction-e15htlq)

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
  implementation 'com.speechly:android-client:0.1.7'
}
```

### Client usage

```kotlin
val speechlyClient: Client = Client.fromActivity(activity = this, UUID.fromString("yourkey"))

speechlyClient.onSegmentChange { segment: Segment ->
    val transcript: String = segment.words.values.map{it.value}.joinToString(" ")
    print(transcript)
}

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

Check out the [example repo filtering app](https://github.com/speechly/android-repo-filtering) for a demo app built using this client.

## Documentation

You can find the detailed API documentation in [GitHub repository](https://github.com/speechly/android-client/blob/main/docs/client/README.md).

## About Speechly

Speechly is a developer tool for building real-time multimodal voice user interfaces. It enables developers and designers to enhance their current touch user interface with voice functionalities for better user experience. Speechly key features:

#### Speechly key features

- Fully streaming API
- Multi modal from the ground up
- Easy to configure for any use case
- Fast to integrate to any touch screen application
- Supports natural corrections such as "Show me red – i mean blue t-shirts"
- Real time visual feedback encourages users to go on with their voice
