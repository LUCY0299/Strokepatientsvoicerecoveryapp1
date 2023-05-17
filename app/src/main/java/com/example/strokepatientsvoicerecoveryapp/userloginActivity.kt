package com.example.strokepatientsvoicerecoveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.registerlogin.*
import kotlinx.android.synthetic.main.userlogin.*



class userloginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.userlogin)

       btn_userLogin.setOnClickListener {

           if (edusername.text.trim().isNotEmpty() || edpassword.text.trim().isNotEmpty()) {
               Toast.makeText(this, "使用者名稱和密碼輸入錯誤!", Toast.LENGTH_SHORT).show()
           }//使用者名稱或密碼不是空的->使用者名稱和密碼輸入錯誤!
           else {
               Toast.makeText(this, "請輸入使用者名稱和密碼!", Toast.LENGTH_SHORT).show()
           }//使用者名稱和密碼都是空的->請輸入使用者名稱和密碼!
           val intent = Intent(this, BasicinformationActivity::class.java);
           startActivity(intent)
       }//當按下登入鍵就會跳轉到用戶資料畫面

            btn_signin.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java);
                startActivity(intent)
            }//當按下註冊鍵就會跳轉到使用者註冊畫面
        }
    }
