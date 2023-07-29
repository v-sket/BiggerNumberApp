package com.example.biggernumber

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btnLeft: Button
    private lateinit var btnRight: Button
    private lateinit var bgView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLeft = findViewById(R.id.btnLeft)
        btnRight = findViewById(R.id.btnRight)
        bgView = findViewById(R.id.bgView)

        btnLeft.setOnClickListener{
            //define variables
            val leftNum = btnLeft.text.toString().toInt()
            val rightNum = btnRight.text.toString().toInt()
            //find max
            val max = findBiggerNumber(leftNum, rightNum)
            //if Left is max
            changeColorIfEqualsMax(leftNum, max, bgView)
            //reset numbers
            generateRandomNumbers(btnLeft)
            generateRandomNumbers(btnRight)
        }

        btnRight.setOnClickListener {
            //define variables
            val leftNum = changeBtnTextToInt(btnLeft)
            val rightNum = changeBtnTextToInt(btnRight)
            //find max
            val max = findBiggerNumber(leftNum, rightNum)
            //if Right is max
            changeColorIfEqualsMax(rightNum, max, bgView)
            //reset numbers
            generateRandomNumbers(btnLeft)
            generateRandomNumbers(btnRight)
        }
    }

    private fun generateRandomNumbers(btn:Button){
        btn.text = (1..100).random().toString()
    }

    private fun findBiggerNumber(x: Int, y: Int): Int {
        return if (x - y > 0) x else y
    }

    private fun changeColorIfEqualsMax(x:Int, max:Int, bgV:View){
        if(x == max) {
            bgV.setBackgroundColor(Color.GREEN)
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            bgV.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun changeBtnTextToInt(btn:Button): Int {
        return btn.text.toString().toInt()
    }
}