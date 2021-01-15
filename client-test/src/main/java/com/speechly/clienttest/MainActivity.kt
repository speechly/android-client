package com.speechly.clienttest

import com.speechly.client.speech.Client
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.speechly.client.slu.Response
import com.speechly.client.slu.Segment
import com.speechly.client.slu.StreamConfig
import com.speechly.client.speech.ContextCallback
import java.util.UUID

class MainActivity : AppCompatActivity() {
    private var speechlyClient: Client? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.speechlyClient = Client.fromContext(
                context = this.applicationContext,
                appId = UUID.randomUUID(),
                language = StreamConfig.LanguageCode.EN_US,
        )

//        Dispatchers.main.launch {
//            this.speechlyClient.startContext(object : ContextCallback {
//                override fun onResponse(response: Response) {
//                    TODO("Not yet implemented")
//                }
//
//                override fun onSegment(segment: Segment) {
//                    TODO("Not yet implemented")
//                }
//
//                override fun onError(t: Throwable) {
//                    TODO("Not yet implemented")
//                }
//            })
//
//            this.speechlyClient.stopContext()
//
//            this.speechlyClient.close()
//        }
    }
}