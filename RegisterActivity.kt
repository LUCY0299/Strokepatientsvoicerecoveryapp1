package com.example.strokepatientsvoicerecoveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import com.example.strokepatientsvoicerecoveryapp.databinding.ActivityMainBinding
import com.example.strokepatientsvoicerecoveryapp.databinding.UserloginBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.registerlogin.*
import java.lang.System.err

// 註冊畫面
class RegisterActivity : AppCompatActivity() {

    private lateinit var t_username : EditText
    private lateinit var t_password : EditText

    // firebase
    private lateinit var dbRef : DatabaseReference

    //不知道要不要用binding #32 33
    // private lateinit var binding: UserloginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // binding = UserloginBinding.inflate(LayoutInflater)
        // setContentView(binding.root)
        setContentView(R.layout.registerlogin)

        t_username = findViewById(R.id.t_username)
        t_password = findViewById(R.id.t_password)

        dbRef = FirebaseDatabase.getInstance().getReference("Users")

        btn_createUser.setOnClickListener{
            saveUserData()
        }

        //當按下登入鍵就會跳轉到使用者登入畫面
        btn_login.setOnClickListener {
            val intent = Intent(this,userloginActivity::class.java);
            startActivity(intent)
        }
    }

    // ========================function======================================
    private fun saveUserData() {
        val username = t_username.text.toString()
        val password = t_password.text.toString()

        if(username.isEmpty()) {
            t_username.error = "記得填寫你的用戶名稱"
        }
        if(password.isEmpty()) {
            t_password.error = "記得填寫你的密碼"
        }

        // 註冊 存進資料庫
        val UserId = dbRef.push().key!!
        val User = UserModel(UserId, username, password)
        dbRef.child(username).setValue(User)
            .addOnCompleteListener {
                Toast.makeText(this, "註冊成功!", Toast.LENGTH_LONG).show()
                t_username.text.clear()
                t_password.text.clear()

                // 要不要直接註冊完直接跳到登入畫面?
                 val intent = Intent(this,userloginActivity::class.java);
                 startActivity(intent)
            }.addOnFailureListener {
                Toast.makeText(this, "註冊失敗", Toast.LENGTH_LONG).show()
            }
    }

}