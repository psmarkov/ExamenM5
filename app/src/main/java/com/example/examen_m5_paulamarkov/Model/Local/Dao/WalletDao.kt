package com.example.examen_m5_paulamarkov.Model.Local.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.examen_m5_paulamarkov.Model.Local.Data.SendMoneyLocal

@Dao
interface WalletDao {


    // insertar lista de Transacciones
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTransac(listTransac: List<SendMoneyLocal>)

    // seleccionar Listado de Transacciones
    @Query("SELECT * FROM Transac_list_table ORDER BY id ASC")
    //@Query(Consultas.comodin)
    fun getAllWallet(): LiveData<List<SendMoneyLocal>>



    // inserta de a 1 Transaccion
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransacDetail(transaccion: SendMoneyLocal)

    @Query("SELECT * FROM Transac_list_table WHERE id = :id")
    fun getWalletDetailById(id: String) : LiveData<SendMoneyLocal>




}