package com.example.electronics.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.electronics.R
import com.example.electronics.activities.StudentsActivity
import com.example.electronics.models.Checker
import kotlinx.android.synthetic.main.adapter_item.view.*

class Adapter(private val myDataset: ArrayList<Checker>, val context: AppCompatActivity) :
    RecyclerView.Adapter<Adapter.MyViewHolder>() {

    class MyViewHolder(val linearLayout: LinearLayout) : RecyclerView.ViewHolder(linearLayout)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): Adapter.MyViewHolder {

        val linearLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_item, parent, false) as LinearLayout

        linearLayout.elevation = 8.0f
        return MyViewHolder(linearLayout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.linearLayout.text.text = myDataset[position].localName
        holder.linearLayout.setOnClickListener{
            val i = Intent(context, StudentsActivity::class.java)
            i.putExtra("id", myDataset[position].id)
            context.startActivity(i)
        }
    }

    override fun getItemCount() = myDataset.size
}