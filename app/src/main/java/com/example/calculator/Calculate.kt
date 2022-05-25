package com.example.calculator

import android.media.VolumeShaper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.NumberFormatException

class Calculate : AppCompatActivity() {

    enum class Оperation{
        plus, minus, multiplication, division
    }

    var EditTextTextNumder1: EditText? = null
    var EditTextTextNumder2: EditText? = null

    var Calculate: Button? = null

    var Plus: Button? = null
    var Minus: Button? = null
    var Multiplication: Button? = null
    var Division: Button? = null

    var Sign: TextView? = null
    var Result: TextView? = null

    var choiceSign: String? = ""

    var result: Double? = null
    var num1: Double? = null
    var num2: Double? = null


    var operation: Оperation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        EditTextTextNumder1 = findViewById<EditText>(R.id.EditTextTextNumder1)
        EditTextTextNumder2 = findViewById<EditText>(R.id.EditTextTextNumder2)

        Calculate =  findViewById<Button>(R.id.Calculate)

        Plus =  findViewById<Button>(R.id.Plus)
        Minus =  findViewById<Button>(R.id.Minus)
        Multiplication =  findViewById<Button>(R.id.Multiplication)
        Division =  findViewById<Button>(R.id.Division)

        Sign = findViewById<TextView>(R.id.Sign)
        Result = findViewById<TextView>(R.id.Result)
    }

    fun onClick(view: View) {

        when (view.getId()){
            R.id.Plus -> {
                choiceSign = "Был выбран знак: +"
                operation = Оperation.plus
            }
            R.id.Minus ->  {
                choiceSign = "Был выбран знак: -"
                operation = Оperation.minus
            }
            R.id.Multiplication ->  {
                choiceSign = "Был выбран знак: *"
                operation = Оperation.multiplication
            }
            R.id.Division ->  {
                choiceSign = "Был выбран знак: /"
                operation = Оperation.division
            }
        }
        Sign?.setText(choiceSign)
    }

    fun onClickCalculate(view: View) {
        if (!(EditTextTextNumder1?.getText().toString().equals(""))
            && !(EditTextTextNumder2?.getText().toString().equals(""))){

                try {
                    num1 = EditTextTextNumder1?.getText().toString().toDouble()
                    num2 = EditTextTextNumder2?.getText().toString().toDouble()

                    if (operation != null){

                        when(operation){
                            Оperation.plus -> result = num1!! + num2!!
                            Оperation.minus -> result = num1!! - num2!!
                            Оperation.multiplication -> result = num1!! * num2!!
                            Оperation.division -> if (num2 != 0.0) result = num1!! / num2!! else {
                                val toast = Toast.makeText(applicationContext, "Ошибка: деление на 0", Toast.LENGTH_SHORT)
                                toast.show()
                            }
                        }
                        if (result != null)
                        Result?.setText("Результат вычисления: " + result.toString())

                    }else{
                        val toast = Toast.makeText(applicationContext, "Выберите операцию", Toast.LENGTH_SHORT)
                        toast.show()
                    }

                }catch (e: NumberFormatException){
                    val toast = Toast.makeText(applicationContext, "Введено не корректное значение", Toast.LENGTH_SHORT)
                    toast.show()
                }

        }else{
            val toast = Toast.makeText(applicationContext, "Введены не все числа", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

}