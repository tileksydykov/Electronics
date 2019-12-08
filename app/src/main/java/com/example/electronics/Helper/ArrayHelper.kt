package com.example.electronics.Helper

import com.example.electronics.activities.StudentsActivity
import com.example.electronics.models.Student

class ArrayHelper {
    companion object Functions {
        fun makeArrayUnique(students: ArrayList<Student>): ArrayList<Student> {
            val newArray = arrayListOf<Student>()

            students.forEach {
                val x = newArray.size
                var i = 0
                var saved = false
                while (x > i) {
                    if (newArray[i].id == it.id) {
                        newArray.removeAt(i)
                        newArray.add(it)
                        saved = true
                    }
                    i++
                }
                if(!saved){
                    newArray.add(it)
                }
            }


            return newArray
        }
    }
}