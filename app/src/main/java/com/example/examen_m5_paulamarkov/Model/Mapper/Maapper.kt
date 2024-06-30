package com.example.examen_m5_paulamarkov.Model.Mapper


import com.example.examen_m5_paulamarkov.Model.Local.Data.SendMoneyLocal
import com.example.examen_m5_paulamarkov.Model.Network.Data.Transaction.SendMoneyResponse



fun fromInternetWalletLocal( Lista: List<SendMoneyResponse>) :List<SendMoneyLocal>{
    return Lista.map {


        SendMoneyLocal(
            id = it.id,
            amount = it.amount,
            concept = it.concept,
            date = it.date,
            type = it.type,
            accountId = it.accountId,
            userId = it.userId,
            toaccountid = it.toaccountid,
            updatedAt = it.updatedAt,
            createdAt = it.createdAt

        )

    }

}



