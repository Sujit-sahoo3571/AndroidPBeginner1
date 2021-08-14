package com.calculationday1test.calculator_day1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get

class Screen2 : AppCompatActivity() {
    //declaration of lateinit variables
    lateinit var et1 : EditText
    lateinit var et2 : EditText
    lateinit var addbtn : Button
    lateinit var option : Spinner
    lateinit var result: TextView
    var newtext : Char = '+'
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)

        et1 = findViewById(R.id.num1)
        et2 = findViewById(R.id.num2)
        addbtn = findViewById(R.id.btn1)
        result = findViewById(R.id.result)
        option = findViewById(R.id.options)

        //spinner data

        val options = arrayOf('+','-','*','/','%')
        option.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,options)


        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
               newtext  = options.get(position)


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text = "Please select an Operator "
            }
        }


        //add button
        addbtn.setOnClickListener {


            val  num1  = et1.text.toString().toDoubleOrNull()
            val num2 = et2.text.toString().toDoubleOrNull()
            if(num1 == null || num2 == null){
                result.text = "Field Value should not be Blank"

            }else{
//                val sum = num1 + num2

                val sum = calculate(newtext).invoke(num1,num2)
                result.text = sum.toString()


            }

        }



    }

    fun calculate(charop : Char): (Double ,Double)->Double{
        return  when(charop){
            '+'->{ a,b -> a + b }
            '-'->{ a,b -> a - b }
            '*'->{ a,b -> a * b }
            '/'->{ a,b -> a / b }
            '%'->{ a,b -> a % b }
            else -> throw  Exception("that's not an operator ")

        }
    }


}