package com.example.examen_m5_paulamarkov.Model.Local.BaseDatos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.examen_m5_paulamarkov.Model.Local.Dao.WalletDao
import com.example.examen_m5_paulamarkov.Model.Local.Data.SendMoneyLocal

@Database(entities=[SendMoneyLocal::class], version = 1,
    exportSchema = false)

abstract class WalletDataBase : RoomDatabase() {

    // REFERENCIA AL DAO PARTE LOCAL
    abstract fun getWalletDao(): WalletDao

    companion object {
        @Volatile
        private var INSTANCE: WalletDataBase? = null

        fun getDataBase(context: Context): WalletDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WalletDataBase::class.java,
                    "CASOWALLET"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }





}