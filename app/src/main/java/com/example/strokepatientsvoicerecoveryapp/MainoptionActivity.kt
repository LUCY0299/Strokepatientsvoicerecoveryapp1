package com.example.strokepatientsvoicerecoveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.mainoption.*

class MainoptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainoption)

        btn_itemPracrice.setOnClickListener {
            val   intent = Intent(this,itemPracriceActivity::class.java);
            startActivity(intent)
        }//當按下類型選擇鍵就會跳轉到類型選擇畫面
        btn_chooseType.setOnClickListener {
            val   intent = Intent(this,chooseTypeActivity::class.java);
            startActivity(intent)
        }//當按下加強練習鍵就會跳轉到加強練習畫面
    }
}