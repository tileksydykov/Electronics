package com.example.electronics.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.electronics.Helper.ArrayHelper
import com.example.electronics.R
import com.example.electronics.adapters.Adapter
import com.example.electronics.adapters.StudentAdapter
import com.example.electronics.data.Firebase
import com.example.electronics.models.Student

class StudentsActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: StudentAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var myDataSet: ArrayList<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)
        val f = Firebase()
        var checkername = intent.getStringExtra("id")
        val data = f.getChecks(checkername)

        myDataSet = arrayListOf()

        viewManager = LinearLayoutManager(this)
        viewAdapter = StudentAdapter(myDataSet, this)

        recyclerView = findViewById<RecyclerView>(R.id.my_s_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        data.observe(this, Observer {
            val arr = ArrayHelper.makeArrayUnique(it)
            viewAdapter.update(arr)
        })
    }
}
