package com.example.strokepatientsvoicerecoveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            val   intent = Intent(this,userloginActivity::class.java);
            startActivity(intent)
        }//當按下登入鍵就會跳轉到使用者登入畫面
        btn_signin.setOnClickListener {
            val   intent = Intent(this,RegisterActivity::class.java);
            startActivity(intent)
        }//當按下註冊鍵就會跳轉到使用者註冊畫面

    }
}