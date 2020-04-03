package com.example.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import kotlin.random.Random

class Main2Activity : AppCompatActivity() {

    var res: Int=0
    private var countofQuestion: Int=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        generationQuestion()
    }
    fun onClick(view: View){
        val selectedVariant=(view as Button).text.toString().toInt()
        if(selectedVariant==res){
            Toast.makeText(this,"Верно",Toast.LENGTH_SHORT).show()
            if(countofQuestion==10){
                val text=Intent(this,Main3Activity::class.java)
                startActivity(text)
            }
            else{
                countofQuestion++
                tvLevel.text= "Level:$countofQuestion"
                generationQuestion()
            }
        }
        else{
            Toast.makeText(this,"Неверно",Toast.LENGTH_SHORT).show()
            val text=Intent(this,Main4Activity::class.java)
            startActivity(text)
        }
    }
    private fun generationQuestion() {
        var firstNumber = Random.nextInt(100)
        val secondNumber = Random.nextInt(100)
        when (Random.nextInt(4)) {
            0 -> {
                tvValue.text = "$firstNumber+$secondNumber"
                res = firstNumber + secondNumber
            }
            1 -> {
                tvValue.text = "$firstNumber-$secondNumber"
                res = firstNumber - secondNumber
            }
            2 -> {
                tvValue.text = "$firstNumber*$secondNumber"
                res = firstNumber * secondNumber
            }
            else -> {
                res= Random.nextInt(100)
                firstNumber=res*secondNumber
                tvValue.text = "$firstNumber/$secondNumber"
                res = firstNumber / secondNumber
            }
        }
        generationWrongAnswer(btnAnswer1)
        generationWrongAnswer(btnAnswer2)
        generationWrongAnswer(btnAnswer3)
        generationWrongAnswer(btnAnswer4)
        when (Random.nextInt(4)) {
            0 -> btnAnswer1.text = res.toString()
            1 -> btnAnswer2.text = res.toString()
            2 -> btnAnswer3.text = res.toString()
            else -> btnAnswer4.text = res.toString()

        }
    }
        private fun generationWrongAnswer(button: Button){
            when(Random.nextBoolean()){
                true->button.text=(res+ Random.nextInt(10)+1).toString()
                else->button.text=(res-Random.nextInt(10)-1).toString()
            }
        }
}

