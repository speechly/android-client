package com.speechly.ui

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.speechly.client.R

class SpeechlyButton(context: Context, attr: AttributeSet) : AppCompatImageView(context, attr) {

    var listener: OnTouchListener? = null
    private var started: Boolean = false

    init {
        super.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                listenForTouch(v, event)
                return true
            }
        })

        setBackgroundResource(R.drawable.ic_micframe)
        setImageResource(R.drawable.ic_start)
    }

    fun listenForTouch(v: View?, event: MotionEvent?) {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                if (!started) {
                    setImageResource(R.drawable.ic_mic)
                    started = true
                }
                scaleUp()
            }

            MotionEvent.ACTION_UP -> {
                scaleDown()
            }
        }
        this.listener?.onTouch(v, event)
    }

    override fun setOnTouchListener(listener: OnTouchListener) {
        this.listener = listener
    }

    fun scaleUp() {
        val va = ValueAnimator.ofFloat(1f, 1.2f)
        va.duration = 500L
        va.addUpdateListener { animation ->
            setScaleX(animation.animatedValue as Float)
            setScaleY(animation.animatedValue as Float)
        }
        va.start()
    }

    fun scaleDown() {
        val va = ValueAnimator.ofFloat(1.2f, 1f)
        va.duration = 300L
        va.addUpdateListener { animation ->
            setScaleX(animation.animatedValue as Float)
            setScaleY(animation.animatedValue as Float)
        }
        va.start()
    }
}