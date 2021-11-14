package com.example.recetadelaabuela.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.recetadelaabuela.R
import com.example.recetadelaabuela.presentation.main.MainActivity

class SplashActivity : AppCompatActivity(){
    private lateinit var imgSplash : LottieAnimationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        imgSplash = findViewById(R.id.imgSplash)

        imgSplash.apply {
            alpha = 0F
            animate().setDuration(1500L).alpha(1F).withEndAction{
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                finish()
            }
        }
    }
}