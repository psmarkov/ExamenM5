package com.example.examen_m5_paulamarkov.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.examen_m5_paulamarkov.R
import com.example.examen_m5_paulamarkov.ViewModel.LoginPage_vm
import com.example.examen_m5_paulamarkov.ViewModel.ToastCallback
import com.example.examen_m5_paulamarkov.databinding.FragmentLoginPageBinding


class LoginPage : Fragment(), ToastCallback {


    private val mimv: LoginPage_vm by viewModels()
    private lateinit var lpBinding:FragmentLoginPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflar la vista
        lpBinding=FragmentLoginPageBinding.inflate(inflater,container,false)

        //Insstancia El viewModel que voy a usar (la clase) ESto va en el Activity  Padre
        //mimv = ViewModelProvider(this)[LoginPage_vm ::class.java]

        mimv.email.observe(this) { email->

            lpBinding.edtEmailAddress.setText(email)

        }

        mimv.pass.observe(this) { pass->

            lpBinding.edtPassword.setText(pass)

        }


        lpBinding.txtRegistro.setOnClickListener {

            it.findNavController().navigate(R.id.action_loginPage_to_signupPage)

        }

        lpBinding.btnLogin.setOnClickListener {

            val email1 = lpBinding.edtEmailAddress.text.toString()
            val pass1 = lpBinding.edtPassword.text.toString()

            // establecer call bal
            mimv?.callback = this

            // Si el resultado de la validacion no es falso es decir los datos
            // son validos entonces abre el fragmento siguiente

            mimv.recibeDatos(email1,pass1)

            mimv.valida.observe(viewLifecycleOwner, Observer  { valido->

                if (valido == true) {

                    view?.findNavController()?.navigate(R.id.action_loginPage_to_homePage)


                } else {
                    Toast.makeText(requireContext(), "Usuario no valido", Toast.LENGTH_SHORT).show()
                }

            })


                //it.findNavController().navigate(R.id.action_loginPage_to_homePage)

        }


        return lpBinding.root
    }


    override fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()

        //Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}