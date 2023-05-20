package com.example.recycler_view.Adaptor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view.MainActivity2
import com.example.recycler_view.Model.ExampleItem
import com.example.recycler_view.R
import com.example.recycler_view.utils.Constants


class ExampleAdaptor(var context: Context, val elements: MutableList<ExampleItem>) :
    RecyclerView.Adapter<ExampleAdaptor.ExampleViewHolder>() //inheriting from the recycler view class
{  //the generic type of it is an inner class we are creating
    //2 constructors first is the context ,2nd is a mutable list of generic type ExampleItem (refer to model package)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        //this function allows us to view our xml
        //inflate the xml so we can see it
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return ExampleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return elements.size //return the number of items
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = elements[position]  //array of the exampleItems
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
    }  //basically displays the title and the description of our items


    inner class ExampleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title: TextView =
            view.findViewById(R.id.title) //view is used to identify which view otherwise compi ler wont know what its viewing
        val description: TextView = view.findViewById(R.id.description)

        init {
            view.setOnClickListener {
                val position = adapterPosition //gets the adapter position that was clicked
                val items = elements[position]
                Toast.makeText(context, items.title, Toast.LENGTH_SHORT).show()
                val intent = Intent(context, MainActivity2::class.java)
                intent.putExtra(Constants.KEY_TITLE, items.title)
                intent.putExtra(Constants.KEY_DESCRIPTION, items.description)

                context.startActivity(intent)

            }
        }


    }
}