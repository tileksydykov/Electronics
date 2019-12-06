package com.example.electronics.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.electronics.R
import com.example.electronics.models.Checker
import kotlinx.android.synthetic.main.adapter_item.view.*

class Adapter(private val myDataset: ArrayList<Checker>) :
    RecyclerView.Adapter<Adapter.MyViewHolder>() {

    class MyViewHolder(val linearLayout: LinearLayout) : RecyclerView.ViewHolder(linearLayout)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): Adapter.MyViewHolder {

        val linearLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_item, parent, false) as LinearLayout

        linearLayout.elevation = 8.0f
        return MyViewHolder(linearLayout)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.linearLayout.text.text = myDataset[position].name
    }



    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}