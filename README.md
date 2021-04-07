<h1 align="center">
<a href="https://www.speechly.com/?utm_source=github&utm_medium=android-client&utm_campaign=header"><img src="https://www.speechly.com/images/logo.png" height="100" alt="Speechly"></a>
</h1>
<h2 align="center">
Complete your touch user interface with voice
</h2>

[Speechly website](https://www.speechly.com/?utm_source=github&utm_medium=android-client&utm_campaign=header)&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;[Docs](https://www.speechly.com/docs/?utm_source=github&utm_medium=android-client&utm_campaign=header)&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;[Blog](https://www.speechly.com/blog/?utm_source=github&utm_medium=android-client&utm_campaign=header)

# Android client for Speechly SLU API

![Release build](https://github.com/speechly/android-client/workflows/Release%20build/badge.svg)
[![License](http://img.shields.io/:license-mit-blue.svg)](LICENSE)

This repository contains the source code for the Android client for [Speechly](https://www.speechly.com/?utm_source=github&utm_medium=android-client&utm_campaign=text) SLU API. Speechly allows you to easily build applications with voice-enabled UIs.

### Requirements

* Android 8.0 (API level 26) and above

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
