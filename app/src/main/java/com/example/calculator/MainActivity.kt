package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var editTextLogin: EditText? = null
    var editTextPassword: EditText? = null
    var button:Button? = null

    var login: String? = "admin"
    var password: String? = "123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         editTextLogin = findViewById<EditText>(R.id.Login)
         editTextPassword = findViewById<EditText>(R.id.Password)
         button = findViewById<Button>(R.id.Button)


    }

    fun onClick(view: android.view.View) {

        if (!editTextLogin?.getText().toString().equals("")){
            if (!editTextPassword?.getText().toString().equals("")){
                if (editTextLogin?.getText().toString().equals(login) && editTextPassword?.getText().toString().equals(password) ){
                    val intent = Intent(this, Calculate::class.java)
                    startActivity(intent)
                }else{
                    val toast = Toast.makeText(applicationContext, "Несоответсвие логина или пароля", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }else{
                val toast = Toast.makeText(applicationContext, "Введите пароль", Toast.LENGTH_SHORT)
                toast.show()
            }
        }else {
            val toast = Toast.makeText(applicationContext, "Введите логин", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}