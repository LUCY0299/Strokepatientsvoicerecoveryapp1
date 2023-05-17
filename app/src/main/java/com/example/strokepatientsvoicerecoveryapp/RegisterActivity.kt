package com.example.strokepatientsvoicerecoveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.registerlogin.*
import kotlinx.android.synthetic.main.userlogin.*


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registerlogin)

        btn_createUser.setOnClickListener {
            if (t_username.text.trim().isNotEmpty() || t_password.text.trim()
                    .isNotEmpty()
            ) {
                Toast.makeText(this, "註冊成功!", Toast.LENGTH_LONG).show()//使用者名稱或密碼不是空的->註冊成功!
            } else {
                Toast.makeText(this, "請填完整!", Toast.LENGTH_LONG).show()//使用者名稱和密碼是空的->請填完整!
            }
        }

       btn_login.setOnClickListener {
            val   intent = Intent(this,userloginActivity::class.java);
            startActivity(intent)
        }//當按下登入鍵就會跳轉到使用者登入畫面
    }
}