package com.calculationday1test.calculator_day1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

//main activity
class MainActivity : AppCompatActivity() {
    //declaration of lateinit variables
    lateinit var et1 : EditText
    lateinit var et2 : EditText
    lateinit var addbtn : Button
    lateinit var rstbtn : Button
    lateinit var newwindow : Button
    lateinit var result: TextView

    //oncreate method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // id integration with variables
        et1 = findViewById(R.id.num1)
        et2 = findViewById(R.id.num2)
        addbtn = findViewById(R.id.btn1)
        result = findViewById(R.id.result)
        rstbtn = findViewById(R.id.btn2)
        newwindow = findViewById(R.id.btn3)
        //add button
        addbtn.setOnClickListener {
            val  num1  = et1.text.toString().toDoubleOrNull()
            val num2 = et2.text.toString().toDoubleOrNull()
            if(num1 == null || num2 == null){
                result.text = "Field Value should not be Blank "

            }else{
                val sum = num1 + num2
                result.text = sum.toString()
            }

        }
        //reset button
        rstbtn.setOnClickListener {
            et1.setText("")
            et2.setText("")
            result.setText("")
        }

        //new window
        newwindow.setOnClickListener {
            val intent = Intent(this, Screen2::class.java )
            startActivity(intent)
        }




    }



}