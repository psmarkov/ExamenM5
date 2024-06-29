package com.example.examen_m5_paulamarkov.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.examen_m5_paulamarkov.Model.Network.Data.User.UsuarioLogEnviaNet
import com.example.examen_m5_paulamarkov.Model.Network.Retrofit.RetrofitClient
import com.example.examen_m5_paulamarkov.R
import com.example.examen_m5_paulamarkov.ViewModel.LoginPage_vm
import com.example.examen_m5_paulamarkov.ViewModel.SignupPage_vm
import com.example.examen_m5_paulamarkov.ViewModel.ToastCallback
import com.example.examen_m5_paulamarkov.databinding.FragmentLoginPageBinding
import com.example.examen_m5_paulamarkov.databinding.FragmentSignupPageBinding
import kotlinx.coroutines.launch


class SignupPage : Fragment(), ToastCallback {

    // retrofit Cliente
    private val networkService2 = RetrofitClient.getRetrofit2()



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


                    //CONECTO CON LA API PARA IR POR EL TOKEN
                    conetaAPI()



                //Toast.makeText(requireContext(), "Cuenta Creada", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_signupPage_to_loginPage)

                }else {
                    Toast.makeText(requireContext(), "Ingrese todos los datos", Toast.LENGTH_SHORT).show()
                }

            })
        }



        return spBinding.root
    }

    private fun conetaAPI() {

        // CREAR USUARIO - ENVIAR DATOS DE USUAARIO Y TOKEN


            lifecycleScope.launch {

                val objUsuarioLogoEnviaNet = UsuarioLogEnviaNet(

                    first_name = "aaaa",
                    last_name = "aaaaaa",
                    email = "aaaaa3@example.com",
                    password = "abc123",
                    roleId = 1,
                    points = 90

                )

                //val usuarioLogNet = networkService2.fetchNewUsu("Bearer $objKen", objUsuarioLogoNet)
                val usuarioLogNet = networkService2.fetchNewUsu(objUsuarioLogoEnviaNet)

                android.util.Log.e("++++++++++ MIS DATOS ********", usuarioLogNet.toString())

                // MUESTRO POR PANTALLA EL DATO DE LA API
                //spBinding.Nombre.text = usuarioLogNet.body()?.first_name

                val aaa = usuarioLogNet.body()?.first_name
                Toast.makeText(requireContext(), "$aaa", Toast.LENGTH_SHORT).show()

            }
    }



    override fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()

        //Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}