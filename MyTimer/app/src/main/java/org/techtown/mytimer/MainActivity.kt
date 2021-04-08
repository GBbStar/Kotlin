package org.techtown.mytimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val minuteTextView:TextView by lazy{
        findViewById<TextView>(R.id.minuteTextView)
    }

    private val secondTextView:TextView by lazy{
        findViewById<TextView>(R.id.secondTextView)
    }

    private val timerSeekBar:SeekBar by lazy {
        findViewById<SeekBar>(R.id.timerSeekbar)
    }


    private var currentTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()

    }

    private fun bindViews(){
        timerSeekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    TODO("Not yet implemented")
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                    TODO("Not yet implemented")
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                    startTimer()
                }
            }
        )
    }

    private fun startTimer(){
        currentTimer = createCount
    }

    private fun createTimer(initialMillis: Long)=
        object : CountDownTimer(initialMillis, 1000L){
            override fun onTick(p0: Long) {
                TODO("Not yet implemented")
            }

            override fun onFinish() {
                TODO("Not yet implemented")
            }
        }

}