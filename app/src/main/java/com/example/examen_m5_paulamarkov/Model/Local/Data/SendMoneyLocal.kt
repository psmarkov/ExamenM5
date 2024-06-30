package com.example.examen_m5_paulamarkov.Model.Local.Data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Transac_list_table")
data class SendMoneyLocal(

    @PrimaryKey
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
