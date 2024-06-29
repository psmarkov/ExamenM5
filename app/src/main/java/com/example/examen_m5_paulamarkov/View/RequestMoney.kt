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
import com.example.examen_m5_paulamarkov.Model.Network.Data.Transaction.SendMoneyEnvia
import com.example.examen_m5_paulamarkov.Model.Network.Retrofit.RetrofitClient
import com.example.examen_m5_paulamarkov.R
import com.example.examen_m5_paulamarkov.ViewModel.RequestMoney_vm
import com.example.examen_m5_paulamarkov.ViewModel.SendMoney_vm
import com.example.examen_m5_paulamarkov.ViewModel.ToastCallback
import com.example.examen_m5_paulamarkov.databinding.FragmentRequestMoneyBinding
import com.example.examen_m5_paulamarkov.databinding.FragmentSendMoneyBinding
import kotlinx.coroutines.launch


class RequestMoney : Fragment(), ToastCallback {

    // retrofit Cliente
    private val networkService2 = RetrofitClient.getRetrofit2()

    // ViewModel y Binding
    private val mimv4: RequestMoney_vm by viewModels()
    private lateinit var rmBinding: FragmentRequestMoneyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflar la vista
        rmBinding= FragmentRequestMoneyBinding.inflate(inflater,container,false)

        rmBinding.btnAtrasRequest.setOnClickListener {

            val cantirdadRM = rmBinding.edtIngCantidadTransferir.toString()
            val descripcionRM = rmBinding.edtIngDescripcion2.toString()


            // establecer call bal
            mimv4?.callback = this

            // ENVIO DATOS A VIEW MODEL
            mimv4.recibeDatosSM(cantirdadRM,descripcionRM)

            mimv4.valida.observe(viewLifecycleOwner, Observer { valida->
                if (valida == true) {


                    //CONECTO CON LA API PARA IR POR EL TOKEN
                    conetaAPI()


                    //Toast.makeText(requireContext(), "Cuenta Creada", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_requestMoney_to_homePage)

                }else {
                    Toast.makeText(requireContext(), "Ingrese todos los datos", Toast.LENGTH_SHORT).show()
                }

            })
        }


        return rmBinding.root
    }

    private fun conetaAPI() {

        // CREAR transaccion - ENVIAR DATOS DE transaccion Y TOKEN


        lifecycleScope.launch {

            val objSendMoneyEnvia = SendMoneyEnvia(

                amount = 500,
                concept ="Mi prueba2",
                date = "2022-10-26 15:00:00",
                type ="topup",
                accountId = 1,
                userId = 4 ,
                toaccountid = 2
            )


            //val usuarioLogNet = networkService2.fetchNewUsu("Bearer $objKen", objUsuarioLogoNet)
            val sendMoneyEnvia = networkService2.fetchTransEnvia(objSendMoneyEnvia)

            android.util.Log.e("++++++++++ MIS DATOS ********", sendMoneyEnvia.toString())

            // MUESTRO POR PANTALLA EL DATO DE LA API
            //spBinding.Nombre.text = usuarioLogNet.body()?.first_name

            val aaa = sendMoneyEnvia.body()?.amount
            val bbb = sendMoneyEnvia.body()?.concept
            Toast.makeText(requireContext(), "dato enviado a la api \n $aaa \n $bbb", Toast.LENGTH_SHORT).show()

        }
    }


    override fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()

        //Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}