package com.example.recycler_view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view.Adaptor.ExampleAdaptor
import com.example.recycler_view.Model.ExampleItem

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adaptor: ExampleAdaptor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val exampleList=generateList(100)
        adaptor=ExampleAdaptor(this,exampleList)//Adaptor for the example list we created
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.adapter=adaptor
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

    }


    private fun generateList(size: Int): MutableList<ExampleItem> {
        val list = mutableListOf<ExampleItem>()
        for (i in 0 until size) {
            list.add(ExampleItem("Title $i", "Description $i"))

        }

        return list
    }
}