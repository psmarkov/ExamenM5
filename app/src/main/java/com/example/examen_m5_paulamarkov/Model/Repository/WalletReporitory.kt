package com.example.examen_m5_paulamarkov.Model.Repository


import androidx.lifecycle.MutableLiveData

import com.example.examen_m5_paulamarkov.Model.Local.Dao.WalletDao
import com.example.examen_m5_paulamarkov.Model.Local.Data.SendMoneyLocal
import com.example.examen_m5_paulamarkov.Model.Mapper.fromInternetWalletLocal
import com.example.examen_m5_paulamarkov.Model.Network.Data.Authentication.AuthentificarNet
import com.example.examen_m5_paulamarkov.Model.Network.Data.Transaction.SendMoneyResponse

import com.example.examen_m5_paulamarkov.Model.Network.Retrofit.RetrofitClient
import com.example.examen_m5_paulamarkov.Model.Token.objKen



class WalletReporitory  (private val walletDao: WalletDao) {

    // retrofit Cliente
    private val networkService = RetrofitClient.getRetrofit()
    private val networkService2 = RetrofitClient.getRetrofit2() // tiene el token

    // dao listado para viewModel
    val walletDaoRepository = walletDao.getAllWallet()

    val listaWallet = MutableLiveData<SendMoneyResponse>()
    val detalleWallet = MutableLiveData<SendMoneyLocal>()


    suspend fun fetchWallet() {
        val objAutentificarNet = AuthentificarNet(
            email = "juanperaz@example.com",
            password = "abc123"
        )

        // OBTENGO EL TOKEN ----------------------------
        val authToken = networkService.fetchTokenNet(objAutentificarNet)
        val token = authToken.body()?.accessToken.toString()

        objKen = token


        val service =
            kotlin.runCatching { networkService.fetchTransLista("Bearer $token") } //Conexion con la api
        service.onSuccess { listResponse ->
            when (listResponse.code()) {
                in 199..299 -> listResponse.body()?.let {
                    android.util.Log.d("TRANSACCION", it.toString())


                    walletDao.insertAllTransac(fromInternetWalletLocal(it))// conexion con el Dao
                }

                else -> android.util.Log.d("Repo", "${listResponse.code()}-${listResponse.errorBody()}")
            }
            service.onFailure {
                android.util.Log.e("Error", "${it.message}")

            }
        }
    }


}