package com.example.examen_m5_paulamarkov.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.examen_m5_paulamarkov.R
import com.example.examen_m5_paulamarkov.databinding.FragmentLoginSignupPageBinding


class LoginSignupPage : Fragment(){


    private lateinit var frBinding: FragmentLoginSignupPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflar el fragmento
        frBinding = FragmentLoginSignupPageBinding.inflate(inflater,container,false)

        frBinding.imgReadme.setOnClickListener {
         it.findNavController().navigate(R.id.action_loginSignupPage_to_README)

        }

        frBinding.btnAtras.setOnClickListener{

            it.findNavController().navigate(R.id.action_loginSignupPage_to_signupPage)
        }
        frBinding.txtIngresar.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginSignupPage_to_loginPage)
        }


        return frBinding.root

    }

}