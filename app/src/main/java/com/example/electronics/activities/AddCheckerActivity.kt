package com.example.electronics.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.electronics.R
import com.example.electronics.data.DB
import com.example.electronics.data.Firebase
import kotlinx.android.synthetic.main.activity_add_checker.*


class AddCheckerActivity : AppCompatActivity() {

    private var db: DB = DB()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_checker)

        open_scanner.setOnClickListener {
            val i = Intent(getActivityContext(), QrCodeScanner::class.java)

            startActivityForResult(i, 1)
        }
    }

    private fun getActivityContext(): AddCheckerActivity = this

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 1) {
            val contents = intent!!.getStringExtra("text")
            label.text = contents

            val f = Firebase()
            val cheker = f.isExistChecker(contents!!)

            cheker.observe(this, Observer {
                if (it.id != "0") {
                    db.addCheker(it)
                    setResult(1, Intent())
                    finish()
                }
            })

        } else {
            onBackPressed()
        }
    }


}
