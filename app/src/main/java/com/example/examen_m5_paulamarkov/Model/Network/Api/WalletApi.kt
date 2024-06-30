package com.example.examen_m5_paulamarkov.Model.Network.Api


import com.example.examen_m5_paulamarkov.Model.Network.Data.Authentication.AuthentificarNet
import com.example.examen_m5_paulamarkov.Model.Network.Data.Authentication.TokenNet
import com.example.examen_m5_paulamarkov.Model.Network.Data.Transaction.SendMoneyEnvia
import com.example.examen_m5_paulamarkov.Model.Network.Data.Transaction.SendMoneyResponse
import com.example.examen_m5_paulamarkov.Model.Network.Data.User.UsuarioLogEnviaNet
import com.example.examen_m5_paulamarkov.Model.Network.Data.User.UsuarioLogNet
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface WalletApi {

    @POST("auth/login")
    suspend fun fetchTokenNet(@Body auth: AuthentificarNet): Response<TokenNet>

    @GET("auth/me")
    suspend fun fetchAuthMe(@Header("Authorization") token:String): Response<UsuarioLogNet>

    @POST("users")
    //suspend fun fetchNewUsu(@Header ("Authorization") token:String, @Body usuario: UsuarioLogNet): Response<UsuarioLogNet>
    suspend fun fetchNewUsu(@Body usuario: UsuarioLogEnviaNet): Response<UsuarioLogNet>

    @GET("users/{id}")
    suspend fun fetchUsuDetalleNet(@Path("id")id:Int): Response<UsuarioLogNet>

    //Crear una Transaccion
    @POST("transactions")
    suspend fun fetchTransEnvia(@Body envia: SendMoneyEnvia) : Response<SendMoneyResponse>

    //Listar todas las transacciones
    @GET("transactions")
    suspend fun fetchTransLista(@Header("Authorization") token:String): Response<List<SendMoneyResponse>>

    //Listar todas las transacciones - Detalle solo 1
    @GET("transactions/{id}")
    suspend fun fetchTransDetalle(@Path("id")id:Int): Response<SendMoneyResponse>


}