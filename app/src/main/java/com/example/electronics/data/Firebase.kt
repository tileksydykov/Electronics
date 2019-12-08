package com.example.electronics.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import com.google.firebase.database.DatabaseError

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import com.example.electronics.models.Checker
import com.example.electronics.models.Student
import kotlin.math.roundToLong


class Firebase {
    private val db = FirebaseDatabase.getInstance()
    val refChekers = db.getReference("chekers")
    val refChecks = db.getReference("checks")
    val localDB = DB()

    val TAG = "electrek"

    fun getCheker(id: String): DatabaseReference {
        return refChekers.child(id)
    }

    fun getChecks(id: String): MutableLiveData<ArrayList<Student>> {
        val result: MutableLiveData<ArrayList<Student>> = MutableLiveData()

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val localData = arrayListOf<Student>()
                val checks = dataSnapshot.children
                checks.forEach{
                    val user = it.child("user").value.toString()
                    val time = it.child("time").value as Double
                    val t = time.roundToLong() * 1000
                    localData.add(
                        Student(
                            user,
                            // localDB.getStudentName(user),
                            user,
                            t
                        )
                    )
                }
                result.value = localData
            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        refChecks.child(id).addValueEventListener(postListener)
        return result
    }

    fun isExistChecker(id: String): MutableLiveData<Checker> {
        val h: MutableLiveData<Checker> = MutableLiveData()
        var found = false
        refChekers.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val chekers = dataSnapshot.children
                for (cheker in chekers) {
                    val u = cheker.child("id").value.toString()
                    if (u == id) {
                        val c = Checker(
                            u,
                            cheker.child("name").value as String,
                            cheker.child("name").value as String,
                            cheker.child("auditorium").value as String
                        )
                        h.value = c
                        found = true
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
        if (!found) {
            h.value = Checker("0", "", "", "")
        }
        return h
    }
}