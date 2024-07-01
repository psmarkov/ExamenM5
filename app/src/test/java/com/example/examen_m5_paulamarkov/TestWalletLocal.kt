package com.example.examen_m5_paulamarkov

import androidx.room.PrimaryKey
import com.example.examen_m5_paulamarkov.Model.Local.Data.SendMoneyLocal
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TestWalletLocal {

    private lateinit var conciertoLocal: SendMoneyLocal

    @Before
    fun setup(){
        conciertoLocal = SendMoneyLocal(



        id = 1,
        amount = "amount 1",
        concept = "concept 1",
        date = "date Mayo 2024",
        type = "type 1" ,
        accountId =1,
        userId =1,
        to_account_id =1,
        updatedAt = "updatedAt 1",
        createdAt = "createdAt 1"

        )

    }


    @After
    fun tearDown(){
        // acciones de limpieza de liberacion de recursos
    }

    @Test
    fun testWineConstructor(){
        // verificar los valores asignados

        assert(conciertoLocal.id == 1)
        assert(conciertoLocal.amount == "amount 1")
        assert(conciertoLocal.concept =="concept 1")
        assert(conciertoLocal.date == "date Mayo 2024")
        assert(conciertoLocal.type == "type 1")
        assert(conciertoLocal.accountId == 1)
        assert(conciertoLocal.userId == 1)
        assert(conciertoLocal.to_account_id == 1)
        assert(conciertoLocal.updatedAt == "updatedAt 1")
        assert(conciertoLocal.createdAt == "createdAt 1")
    }


}