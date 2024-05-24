package com.example.examen_m5_paulamarkov.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.examen_m5_paulamarkov.R
import com.example.examen_m5_paulamarkov.ViewModel.LoginPage_vm
import com.example.examen_m5_paulamarkov.ViewModel.SignupPage_vm
import com.example.examen_m5_paulamarkov.ViewModel.ToastCallback
import com.example.examen_m5_paulamarkov.databinding.FragmentLoginPageBinding
import com.example.examen_m5_paulamarkov.databinding.FragmentSignupPageBinding


class SignupPage : Fragment(), ToastCallback {

    private val mimv2: SignupPage_vm by viewModels()
    private lateinit var spBinding: FragmentSignupPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflar la vista
        spBinding=FragmentSignupPageBinding.inflate(inflater,container,false)

        spBinding.btnAtras.setOnClickListener {

            val nombreSP = spBinding.edtNombre.text.toString()
            val apellidoSP = spBinding.edtApellido.text.toString()
            val emailSP = spBinding.edtEmailAddress.text.toString()
            val passSP = spBinding.edtPassword.text.toString()
            val repassSP = spBinding.edtRePass.text.toString()

            // establecer call bal
            mimv2?.callback = this

            // ENVIO DATOS A VIEW MODEL
            mimv2.recibeDatosSP(nombreSP,apellidoSP,emailSP,passSP,repassSP)

            mimv2.valida.observe(viewLifecycleOwner, Observer { valida->
                if (valida == true) {

                //Toast.makeText(requireContext(), "Cuenta Creada", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_signupPage_to_loginPage)

                }else {
                    Toast.makeText(requireContext(), "Ingrese todos los datos", Toast.LENGTH_SHORT).show()
                }

            })
        }



        return spBinding.root
    }
    override fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()

        //Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}