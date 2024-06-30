package com.example.examen_m5_paulamarkov.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.examen_m5_paulamarkov.Model.Local.BaseDatos.WalletDataBase
import com.example.examen_m5_paulamarkov.Model.Local.Data.SendMoneyLocal
import com.example.examen_m5_paulamarkov.Model.Network.Data.Transaction.SendMoneyResponse
import com.example.examen_m5_paulamarkov.Model.Repository.WalletReporitory
import kotlinx.coroutines.launch

class HomePage_vm (application: Application): AndroidViewModel(application) {


    //conecta con el repo
    private val repository : WalletReporitory
    private val detalleLiveData = MutableLiveData<SendMoneyLocal>()
    private var seleccionado :String ="-1"


    init { //inicializa el repo, llama los datos y dao
        val bd = WalletDataBase.getDataBase(application)
        val dao = bd.getWalletDao()
        repository = WalletReporitory(dao)

        //LAMAR A FECHTWINE
        viewModelScope.launch {
            repository.fetchWallet() //del repositorio

        }
    }


    // listado de los elementos
    fun getWalletList(): LiveData<List<SendMoneyLocal>> = repository.walletDaoRepository


}