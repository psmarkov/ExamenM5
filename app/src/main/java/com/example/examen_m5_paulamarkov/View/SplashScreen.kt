package com.example.examen_m5_paulamarkov.View

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examen_m5_paulamarkov.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var spBinding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inflar la vista
        spBinding = ActivitySplashScreenBinding.inflate(layoutInflater)

        setContentView(spBinding.root)

        spBinding.main.setOnClickListener {
           val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

    }
}