package com.example.examen_m5_paulamarkov.View

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.examen_m5_paulamarkov.ViewModel.LoginPage_vm
import com.example.examen_m5_paulamarkov.ViewModel.SignupPage_vm
import com.example.examen_m5_paulamarkov.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var miBinding: ActivityMainBinding
    private lateinit var  mimv: LoginPage_vm
    private lateinit var  mimv_SignupPage: SignupPage_vm


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar la vista
        miBinding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(miBinding.root)


        //Insstancia El viewModel que voy a usar (la clase)
        mimv = ViewModelProvider(this)[LoginPage_vm ::class.java]
        mimv_SignupPage = ViewModelProvider(this)[SignupPage_vm ::class.java]


    }
}


