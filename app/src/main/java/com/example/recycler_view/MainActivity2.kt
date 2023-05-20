package com.example.recycler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.recycler_view.utils.Constants

class MainActivity2 : AppCompatActivity() {
    private lateinit var titletextview:TextView
    private lateinit var descriptiontextview:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        titletextview=findViewById(R.id.textview_title)
        descriptiontextview=findViewById(R.id.textview_description)

        val data=intent.extras
        data?.let{
            titletextview.text=it.getString(Constants.KEY_TITLE)
            descriptiontextview.text=it.getString(Constants.KEY_DESCRIPTION)
        }




    }
}