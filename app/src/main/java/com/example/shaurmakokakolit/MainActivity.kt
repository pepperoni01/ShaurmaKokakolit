package com.example.shaurmakokakolit

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var reset: Button
    private var active = 1
    private var firstpl = ArrayList<Int>()
    private var secondpl = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

    }

    private fun init(){
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        reset = findViewById(R.id.resetButton)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        reset.setOnClickListener(this)

    }

    override fun onClick(clickedView: View?) {
        if(clickedView is Button){
            var buttonNum = 0
            when(clickedView.id) {
                R.id.button1 -> buttonNum = 1
                R.id.button2 -> buttonNum = 2
                R.id.button3 -> buttonNum = 3
                R.id.button4 -> buttonNum = 4
                R.id.button5 -> buttonNum = 5
                R.id.button6 -> buttonNum = 6
                R.id.button7 -> buttonNum = 7
                R.id.button8 -> buttonNum = 8
                R.id.button9 -> buttonNum = 9
                R.id.resetButton -> buttonNum = 10
            }

            if(buttonNum != 0 && buttonNum!= 10){
                playGame(clickedView, buttonNum)
            }else{
                reset()
            }
        }

    }


    private fun playGame(clickedView: Button, buttonNum: Int) {

        if(active == 1){
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.RED)
            firstpl.add(buttonNum)
            active = 2
        }else{
            clickedView.text = "O"
            clickedView.setBackgroundColor(Color.BLUE)
            secondpl.add(buttonNum)
            active = 1
        }
        clickedView.isEnabled = false
        check()

    }

    private fun check(){
        var winner = 0
        if(firstpl.contains(1) && firstpl.contains(2) && firstpl.contains(3)){
            winner = 1
        }
        if(firstpl.contains(4) && firstpl.contains(5) && firstpl.contains(6)){
            winner = 1
        }
        if(firstpl.contains(7) && firstpl.contains(8) && firstpl.contains(9)){
            winner = 1
        }
        if(firstpl.contains(1) && firstpl.contains(4) && firstpl.contains(7)){
            winner = 1
        }
        if(firstpl.contains(2) && firstpl.contains(5) && firstpl.contains(8)){
            winner =1
        }
        if(firstpl.contains(3) && firstpl.contains(6) && firstpl.contains(9)){
            winner = 1
        }
        if(firstpl.contains(1) && firstpl.contains(5) && firstpl.contains(9)){
            winner = 1
        }
        if(firstpl.contains(3) && firstpl.contains(5) && firstpl.contains(7)){
            winner = 1
        }
        if(secondpl.contains(1) && secondpl.contains(2) && secondpl.contains(3)){
            winner = 2
        }
        if(secondpl.contains(4) && secondpl.contains(5) && secondpl.contains(6)){
            winner = 2
        }
        if(secondpl.contains(7) && secondpl.contains(8) && secondpl.contains(9)){
            winner = 2
        }
        if(secondpl.contains(1) && secondpl.contains(4) && secondpl.contains(7)){
            winner = 2
        }
        if(secondpl.contains(2) && secondpl.contains(5) && secondpl.contains(8)){
            winner = 2
        }
        if(secondpl.contains(3) && secondpl.contains(6) && secondpl.contains(9)){
            winner = 2
        }
        if(secondpl.contains(1) && secondpl.contains(5) && secondpl.contains(9)){
            winner = 2
        }
        if(secondpl.contains(3) && secondpl.contains(5) && secondpl.contains(7)){
            winner = 2
        }
        if(firstpl.size + secondpl.size == 9){
            winner = 3
        }

        if(winner != 0){
            if(winner == 1){
                Toast.makeText(this,"X Wins!", Toast.LENGTH_LONG).show()
            }
            if (winner == 2) {
                Toast.makeText(this, "O Wins!", Toast.LENGTH_LONG).show()
            }
            if(winner == 3){
                Toast.makeText(this, "Tie!", Toast.LENGTH_LONG).show()

            }
            disableButtons()

        }




    }
    private fun disableButtons(){
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false

    }

    private fun reset(){
        firstpl = ArrayList<Int>()
        secondpl = ArrayList<Int>()
        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""
        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true
        button1.setBackgroundColor(Color.GRAY)
        button2.setBackgroundColor(Color.GRAY)
        button3.setBackgroundColor(Color.GRAY)
        button4.setBackgroundColor(Color.GRAY)
        button5.setBackgroundColor(Color.GRAY)
        button6.setBackgroundColor(Color.GRAY)
        button7.setBackgroundColor(Color.GRAY)
        button8.setBackgroundColor(Color.GRAY)
        button9.setBackgroundColor(Color.GRAY)
        active = 1
        init()
    }


}