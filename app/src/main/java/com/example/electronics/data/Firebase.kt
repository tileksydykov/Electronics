package com.example.electronics.data

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import com.google.firebase.database.DatabaseError

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import com.example.electronics.models.Checker





class Firebase{
    private val db = FirebaseDatabase.getInstance()
    val refChekers = db.getReference("chekers")

    val TAG = "electrek"

    fun getCheker(id: String):DatabaseReference{
        return refChekers.child(id)
    }

    fun isExistChecker(id: String):MutableLiveData<Checker>{
        val h:MutableLiveData<Checker> = MutableLiveData()
        var found = false
        refChekers.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val chekers = dataSnapshot.children
                for (cheker in chekers) {
                    val u = cheker.child("id")
                    val g = u.value as Long
                    if(g.toString() == id){
                        val c = Checker(g, cheker.child("name").value as String, cheker.child("auditorium").value as String)
                        h.value =  c
                        found = true
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
        if(!found){
            h.value = Checker(0, "", "")
        }
        return h
    }

    fun getChekerValues(id: String):MutableLiveData<Checker>{
        return MutableLiveData()
    }
}