package com.haikalharin.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_AGE = "extra_age"
//        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
           R.id.btn_move_activity ->{
               val moveIntent = Intent (this@MainActivity, MoveActivity::class.java)
               startActivity(moveIntent)
           }
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent (this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(EXTRA_NAME, "Dicoding Academy Boy")
                moveWithDataIntent.putExtra(EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_move_activity_object -> {
                val person = Person(
                    "Dicoding Academy Boy",
                    5,
                    "academy@dicoding.com",
                    "Banding"
                )
                val moveWithObjectIntent = Intent (this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON,person)
                startActivity(moveWithObjectIntent)

            }
            R.id.btn_dial_number -> {
                val phoneNumber = "085778813515"
                val dialPhoneIntent = Intent (Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}
