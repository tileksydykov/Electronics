package com.example.electronics

import com.google.firebase.database.FirebaseDatabase
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun hellTest(){
        val db = FirebaseDatabase.getInstance()
        val refChekers = db.getReference("chekers")

        println(refChekers.child("1231243"))
    }

}
