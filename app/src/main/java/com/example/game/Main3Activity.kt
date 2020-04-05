package com.example.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var rightAnswersCount=intent.getIntExtra(Main2Activity.RIGTH_ANSWERS_COUNT,11)
        tvScore.text="$rightAnswersCount/${Main2Activity.level_Count}"
        tvText.text=intent.getStringExtra("intent")
        val myanim:Animation=AnimationUtils.loadAnimation(this,R.anim.logo_anim)
        tvText.startAnimation(myanim)
        btnGoTo.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
}
