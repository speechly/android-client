<div align="center" markdown="1">
<br/>

![speechly-logo-duo-black](https://user-images.githubusercontent.com/2579244/193574443-130d16d6-76f1-4401-90f2-0ed753b39bc0.svg#gh-light-mode-only)
![speechly-logo-duo-white](https://user-images.githubusercontent.com/2579244/193574464-e682b2ce-dd48-4f70-88d4-a1fc5241fa47.svg#gh-dark-mode-only)

[Website](https://www.speechly.com/)
&ensp;&middot;&ensp;
[Docs](https://docs.speechly.com/)
&ensp;&middot;&ensp;
[Support](https://github.com/speechly/speechly/discussions)
&ensp;&middot;&ensp;
[Blog](https://www.speechly.com/blog/)
&ensp;&middot;&ensp;
[Login](https://api.speechly.com/dashboard/)

<br/>
</div>

# Speechly Android Client

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
