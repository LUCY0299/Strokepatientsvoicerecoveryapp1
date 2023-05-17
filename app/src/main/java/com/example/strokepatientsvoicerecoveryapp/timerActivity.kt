package com.example.strokepatientsvoicerecoveryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.strokepatientsvoicerecoveryapp.databinding.TimerBinding
import java.util.*



    class timerActivity : AppCompatActivity() {

        lateinit var binding: TimerBinding
        lateinit var dataHelper: DataHelper

        private val timer = Timer()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = TimerBinding.inflate(layoutInflater)
            setContentView(binding.root)
            dataHelper = DataHelper(applicationContext)


            binding.startButton.setOnClickListener{ startStopAction() }
            binding.resetButton.setOnClickListener{ resetAction() }

            if(dataHelper.timerCounting())
            {
                startTimer()
            }
            else
            {
                stopTimer()
                if(dataHelper.startTime() != null && dataHelper.stopTime() != null)
                {
                    val time = Date().time - calcRestartTime().time
                    binding.timeTV.text = timeStringFromLong(time)
                }
            }

            timer.scheduleAtFixedRate(TimeTask(), 0, 500)
        }

        private inner class TimeTask: TimerTask()
        {
            override fun run()
            {
                if(dataHelper.timerCounting())
                {
                    val time = Date().time - dataHelper.startTime()!!.time
                    binding.timeTV.text = timeStringFromLong(time)
                }
            }
        }

        private fun resetAction()
        {
            dataHelper.setStopTime(null)
            dataHelper.setStartTime(null)
            stopTimer()
            binding.timeTV.text = timeStringFromLong(0)
        }

        private fun stopTimer()
        {
            dataHelper.setTimerCounting(false)
            binding.startButton.text = getString(R.string.start)
        }

        private fun startTimer()
        {
            dataHelper.setTimerCounting(true)
            binding.startButton.text = getString(R.string.stop)
        }

        private fun startStopAction()
        {
            if(dataHelper.timerCounting())
            {
                dataHelper.setStopTime(Date())
                stopTimer()
            }
            else
            {
                if(dataHelper.stopTime() != null)
                {
                    dataHelper.setStartTime(calcRestartTime())
                    dataHelper.setStopTime(null)
                }
                else
                {
                    dataHelper.setStartTime(Date())
                }
                startTimer()
            }
        }

        private fun calcRestartTime(): Date
        {
            val diff = dataHelper.startTime()!!.time - dataHelper.stopTime()!!.time
            return Date(System.currentTimeMillis() + diff)
        }

        private fun timeStringFromLong(ms: Long): String
        {
            val seconds = (ms / 1000) % 60
            val minutes = (ms / (1000 * 60) % 60)
            return makeTimeString(minutes, seconds)
        }

        private fun makeTimeString(minutes: Long, seconds: Long): String
        {
            return String.format("%02d:%02d", minutes, seconds)
        }
    }











