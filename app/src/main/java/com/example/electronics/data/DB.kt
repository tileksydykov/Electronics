package com.example.electronics.data

import com.example.electronics.models.Checker
import io.paperdb.Book
import io.paperdb.Paper

class DB {

    private val CHECKERS = "checkers"

    private var db: Book = Paper.book()

    fun getCheckers(): ArrayList<Checker> {
        if (db.exist(CHECKERS))
            return db.read(CHECKERS, arrayListOf())
        else
            return arrayListOf<Checker>()
    }

    fun addCheker(c: Checker) {
        val a = getCheckers()
        a.add(c)
        db.write(CHECKERS, a)
    }

    fun getChekerById(id: Long): Checker {
        val a = getCheckers()
        a.forEach {
            if (it.id == id)
                return it
        }
        return Checker(0, "", "")
    }

    fun isCheckerExist(id: Long): Boolean {
        val i: Long = 0
        return getChekerById(id).id != i
    }
}