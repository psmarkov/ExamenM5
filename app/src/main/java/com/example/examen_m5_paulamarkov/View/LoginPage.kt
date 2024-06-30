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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.examen_m5_paulamarkov.Model.Network.Data.Authentication.AuthentificarNet
import com.example.examen_m5_paulamarkov.Model.Network.Retrofit.RetrofitClient
import com.example.examen_m5_paulamarkov.Model.Token.objKen
import com.example.examen_m5_paulamarkov.R
import com.example.examen_m5_paulamarkov.ViewModel.LoginPage_vm
import com.example.examen_m5_paulamarkov.ViewModel.ToastCallback
import com.example.examen_m5_paulamarkov.databinding.FragmentLoginPageBinding
import kotlinx.coroutines.launch


class LoginPage : Fragment(){

    // retrofit Cliente
    private val networkService = RetrofitClient.getRetrofit()
   

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
            //mimv?.callback = this

            // Si el resultado de la validacion no es falso es decir los datos
            // son validos entonces abre el fragmento siguiente

            mimv.recibeDatos(email1,pass1)

            mimv.valida.observe(viewLifecycleOwner, Observer  { valido->

                if (valido == true) {

                    //CONECTO CON LA API PARA IR POR EL TOKEN
                    conetaAPI()



                    view?.findNavController()?.navigate(R.id.action_loginPage_to_homePage)


                } else {
                    val a = 0
                   // Toast.makeText(requireContext(), "Usuario no valido", Toast.LENGTH_SHORT).show()
                }

            })


                //it.findNavController().navigate(R.id.action_loginPage_to_homePage)

        }


        return lpBinding.root
    }



    private fun conetaAPI(){

            // AUTENTIFICARSE - ENVIAR EMAIL Y PASS - RECIBIR TOKEN - RECIBIR USUARIO ACTUAL
            lifecycleScope.launch {

                /*
               // enviar datos ingresados en el view
               val email2 = lpBinding.edtEmailAddress.text.toString()
               val pass2 = lpBinding.edtPassword.text.toString()
               Toast.makeText(requireContext(), email2, Toast.LENGTH_SHORT).show()
               Toast.makeText(requireContext(), pass2, Toast.LENGTH_SHORT).show()


               val objAutentificarNet = AuthentificarNet(
                   email = email2,
                   password = pass2
               )

                */

                    val objAutentificarNet = AuthentificarNet(
                        email = "juanperaz@example.com",
                        password = "abc123"
                    )

                    // OBTENGO EL TOKEN ----------------------------
                    val authToken = networkService.fetchTokenNet(objAutentificarNet)
                    val token = authToken.body()?.accessToken.toString()

                    objKen = token

                    //lpBinding.txtToken.text = token
                    //Toast.makeText(requireContext(), "$token", Toast.LENGTH_SHORT).show()

                    // CON EL TOKEN PIDO DATOS A LA API
                    val usuarioLogNet = networkService.fetchAuthMe("Bearer $token")

                    // MUESTRO POR PANTALLA EL DATO DE LA API
                    //lpBinding.Nombre.text = usuarioLogNet.body()?.first_name
                    //val aaa = usuarioLogNet.body()?.first_name

                    //Toast.makeText(requireContext(), "$aaa", Toast.LENGTH_SHORT).show()
            }

    }

   // override fun showToast(message: String) {
   //     Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()

        //Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
  //  }

}