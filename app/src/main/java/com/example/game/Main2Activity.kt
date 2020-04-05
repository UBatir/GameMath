package com.example.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import kotlin.random.Random

class Main2Activity : AppCompatActivity() {

    companion object{
        const val level_Count=10
        const val RIGTH_ANSWERS_COUNT="rightAnswersCount"
    }

    var res: Int=0
    private var countofQuestion: Int=1
    private var rightAnswers: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        generationQuestion()
    }
    fun onClick(view: View){
        val selectedVariant=(view as Button).text.toString().toInt()
        if(selectedVariant==res){
            rightAnswers++
            tvScores.text="Score:$rightAnswers"
            Toast.makeText(this,"Верно",Toast.LENGTH_SHORT).show()
            if(countofQuestion== level_Count){
                val intent=Intent(this,Main3Activity::class.java)
                intent.putExtra(RIGTH_ANSWERS_COUNT,rightAnswers)
                intent.putExtra("intent","WIN!")
                startActivity(intent)
            }
            else{
                countofQuestion++
                tvLevel.text= "Level:$countofQuestion"
                generationQuestion()
            }
        }
        else{
            Toast.makeText(this,"Неверно",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,Main3Activity::class.java)
            intent.putExtra(RIGTH_ANSWERS_COUNT,rightAnswers)
            intent.putExtra("intent","GAME OVER")
            startActivity(intent)
        }
    }
    private fun generationQuestion() {
        var firstNumber = Random.nextInt(100)
        var secondNumber = Random.nextInt(100)
        var thirdNumber = Random.nextInt(100)
        val fourthNumber = Random.nextInt(100)
        if(countofQuestion>=8){
            hardLevel()
        }
        else if(countofQuestion>=5){
            middleLevel()
        }
        else{
            easyLevel()
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
    private fun easyLevel() {
        var firstNumber = Random.nextInt(100)
        var secondNumber = Random.nextInt(100)
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
                res = Random.nextInt(100)
                firstNumber = res * secondNumber
                tvValue.text = "$firstNumber/$secondNumber"
                res = firstNumber / secondNumber
            }
        }
    }
        private fun middleLevel(){
            var firstNumber = Random.nextInt(100)
            var secondNumber = Random.nextInt(100)
            var thirdNumber = Random.nextInt(100)
            val fourthNumber = Random.nextInt(100)
        when (Random.nextInt(4)) {
            0 -> {
                tvValue.text = "$firstNumber+$secondNumber*$thirdNumber"
                res = firstNumber + secondNumber*thirdNumber
            }
            1 -> {
                secondNumber=fourthNumber*thirdNumber
                tvValue.text = "$firstNumber-$secondNumber/$thirdNumber"
                res = firstNumber - secondNumber/thirdNumber
            }
            2 -> {
                tvValue.text = "$firstNumber*$secondNumber*$thirdNumber"
                res = firstNumber * secondNumber*thirdNumber
            }
            else -> {
                res= Random.nextInt(100)
                firstNumber=res*secondNumber
                tvValue.text = "$firstNumber/$secondNumber-$thirdNumber"
                res = firstNumber / secondNumber-thirdNumber
            }
        }
    }
        private fun hardLevel(){
            var firstNumber = Random.nextInt(100)
            var secondNumber = Random.nextInt(100)
            var thirdNumber = Random.nextInt(100)
            val fourthNumber = Random.nextInt(100)
        when (Random.nextInt(4)) {
            0 -> {
                tvValue.text = "$firstNumber+$secondNumber*$thirdNumber*$fourthNumber"
                res = firstNumber + secondNumber*thirdNumber*fourthNumber
            }
            1 -> {
                firstNumber=thirdNumber*fourthNumber
                tvValue.text = "$firstNumber*$secondNumber/($thirdNumber+$fourthNumber)"
                res = firstNumber * secondNumber/(thirdNumber+fourthNumber)
            }
            2 -> {
                thirdNumber=fourthNumber*secondNumber
                tvValue.text = "$firstNumber*$secondNumber-$thirdNumber/$fourthNumber"
                res = firstNumber * secondNumber-thirdNumber/fourthNumber
            }
            else -> {
                res= Random.nextInt(100)
                firstNumber=res*secondNumber*thirdNumber
                tvValue.text = "$firstNumber/$secondNumber/$thirdNumber+$fourthNumber"
                res = firstNumber / secondNumber/thirdNumber+fourthNumber
            }
        }
    }
}

