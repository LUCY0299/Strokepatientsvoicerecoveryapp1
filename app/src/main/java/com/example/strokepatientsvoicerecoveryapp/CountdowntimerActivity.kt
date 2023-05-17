package com.example.strokepatientsvoicerecoveryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.os.CountDownTimer
import java.util.*
import java.util.concurrent.TimeUnit

class CountdowntimerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.countdown_timer)

        val textView = findViewById<TextView>(R.id.countdown_timer)
        val timeDuration = TimeUnit.MINUTES.toMillis(15)//設定倒數時間長短
        val tickInterval: Long = 10//沿途接收回調的間隔

        object : CountDownTimer(timeDuration, tickInterval) {
            var millis: Long = 1000 //1000=1秒
            override fun onTick(millisUntilFinished: Long) {
                millis = millis - tickInterval
                if (millis == 0L) millis = 1000
                val timerText = String.format(
                    Locale.getDefault(), "%2d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                            TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(
                                    millisUntilFinished
                                )//公式
                            ),
                    millis
                )
                textView.text = timerText
            }

            override fun onFinish() {
                textView.text = "時間到了"
            }//倒數完畢時
        }.start()
    }
}