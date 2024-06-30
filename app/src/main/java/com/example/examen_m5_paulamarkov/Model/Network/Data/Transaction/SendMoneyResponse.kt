package com.example.examen_m5_paulamarkov.Model.Network.Data.Transaction

import com.google.gson.annotations.SerializedName

data class SendMoneyResponse(

    val id : Int,
    val amount : String,
    val concept : String,
    val date : String,
    val type : String,
    val accountId : Int,
    val userId : Int,

    @SerializedName("to_account_id")
    val toaccountid : Int,

    val updatedAt : String,
    val createdAt : String


)
