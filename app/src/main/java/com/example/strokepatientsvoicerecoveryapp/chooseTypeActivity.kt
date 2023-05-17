package com.example.strokepatientsvoicerecoveryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class chooseTypeActivity: AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<Dataclass>
    lateinit var imageList:Array<Int>
    lateinit var titleList:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_type)

        imageList= arrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.images3,
            R.drawable.images10,
            R.drawable.images6,
            R.drawable.images7,
            R.drawable.images9,
        )//圖片按照順序
        titleList= arrayOf(
            "節慶","食物","飲料","衣服","身體部位","心情","住所"
        )//標題按照順序
        recyclerView=findViewById(R.id.rv_Type)
        recyclerView.layoutManager=LinearLayoutManager(this)//LayoutManager 來指定 RecyclerView 排列的方式
        recyclerView.setHasFixedSize(true)

        dataList= arrayListOf<Dataclass>()
        getDate()
    }
    private fun getDate(){
        for(i in imageList.indices){
            val dataclass=Dataclass(imageList[i],titleList[i])
            dataList.add(dataclass)
        }//獲得索引的資訊，有另創一個Dataclass
        recyclerView.adapter=Adapterclass(dataList)
    }

}