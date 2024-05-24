package com.example.examen_m5_paulamarkov.View

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examen_m5_paulamarkov.databinding.ActivityReadmeBinding

class README : AppCompatActivity() {

    private lateinit var miBReadme: ActivityReadmeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar la vista
        miBReadme =ActivityReadmeBinding.inflate(layoutInflater)
        setContentView(miBReadme.root)

        miBReadme.btnAtras.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }





    }
}