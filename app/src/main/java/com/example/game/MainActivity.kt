package com.example.game

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myanim: Animation = AnimationUtils.loadAnimation(this,R.anim.button_anim)
        imgLogo.startAnimation(myanim)
        btnPlay.setOnClickListener {
            intent = Intent(this, Main2Activity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        btnExit.setOnClickListener {
            finish()
        }
    }
}