package com.example.electronics.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.electronics.R
import com.example.electronics.models.Student
import kotlinx.android.synthetic.main.student_adapter_item.view.*

class StudentAdapter(private var myDataset: ArrayList<Student>, private val context :AppCompatActivity) :
        RecyclerView.Adapter<StudentAdapter.MyViewHolder>() {
    class MyViewHolder(val linearLayout: LinearLayout) : RecyclerView.ViewHolder(linearLayout)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): StudentAdapter.MyViewHolder {
        val linearLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.student_adapter_item, parent, false) as LinearLayout

        return MyViewHolder(linearLayout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val p :Student =  myDataset[position]
        holder.linearLayout.inner.name.text = p.name
        holder.linearLayout.inner.time.text = p.getHourMinute()
    }
    override fun getItemCount() = myDataset.size

    fun update(myDataset: ArrayList<Student>){
        this.myDataset = myDataset
        notifyDataSetChanged()
    }
}