package com.example.examen_m5_paulamarkov.Model.Network.Data.User

data class UsuarioLogEnviaNet (

    var first_name: String,
    val last_name: String,
    val email: String,
    val password: String,
    val points: Int,
    val roleId: Int


)