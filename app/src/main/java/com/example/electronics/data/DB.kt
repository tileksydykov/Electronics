package com.example.electronics.data

import com.example.electronics.models.Checker
import com.example.electronics.models.Student
import io.paperdb.Book
import io.paperdb.Paper

class DB {

    private val CHECKERS = "checkers"
    private val STUDENTS = "students"

    private var db: Book = Paper.book()

    fun getCheckers(): ArrayList<Checker> {
        return db.read(CHECKERS, arrayListOf())
    }

    fun addCheker(c: Checker) {
        val a = getCheckers()
        a.add(c)
        db.write(CHECKERS, a)
    }

    fun getStudentName(id: String): String{
        val students = getStudents()
        students.forEach{
            if(it.id == id){
                return it.name
            }
        }
        return "NOT REGISTERED"
    }

    fun getStudents(): ArrayList<Student> {

        return db.read(STUDENTS, arrayListOf())
    }

    fun getChekerById(id: String): Checker {
        val a = getCheckers()
        a.forEach {
            if (it.id == id)
                return it
        }
        return Checker("0", "", "", "")
    }

    fun isCheckerExist(id: String): Boolean {
        val i: String = ""
        return getChekerById(id).id != i
    }
}