package com.example.electronics.data

import com.example.electronics.models.Cheker
import io.paperdb.Book
import io.paperdb.Paper

class DB{

    private val CHECKERS = "checkers"

    private var db: Book = Paper.book()

    fun getCheckers(): ArrayList<Cheker>{
        if(db.exist(CHECKERS)){
            return db.read(CHECKERS, arrayListOf())
        }else{
            return arrayListOf<Cheker>()
        }
    }

    fun addCheker(c :Cheker){
        val a = getCheckers()
        a.add(c)
        db.write(CHECKERS, a)
    }
}