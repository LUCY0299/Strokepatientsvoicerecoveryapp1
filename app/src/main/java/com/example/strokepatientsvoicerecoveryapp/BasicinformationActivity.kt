package com.example.strokepatientsvoicerecoveryapp


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.basic_information.*
import kotlinx.android.synthetic.main.registerlogin.*


class BasicinformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basic_information)

        send.setOnClickListener {
            val   intent = Intent(this,MainoptionActivity::class.java);
            startActivity(intent)
        }//當按下送出鍵就會跳轉到主題選擇畫面
    }
}