package com.example.examen_m5_paulamarkov.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SendMoney_vm : ViewModel(), ToastCallback {

    // XML datos para observar y variable para validar ------------------------------------------

    private val _cantidad = MutableLiveData<String>()
    val cantidad: LiveData<String> get() = _cantidad

    private val _descripcion = MutableLiveData<String>()
    val descripcion: LiveData<String> get() = _descripcion



    private val _valida = MutableLiveData<Boolean>()
    val valida: LiveData<Boolean> get() = _valida

    // para hacer llamadoa  toast
    var callback: ToastCallback? = null

    // -----------------------------------------------------------------------

    fun recibeDatosSM(cantidad:String,descripcion:String) {
        _cantidad.value = cantidad
        _descripcion.value = descripcion

        _valida.value = true

        validarDatos()

        //Muestra un toast si los  datos se ingresaron bien
        showToast("Datos Válidos")

    }

    private fun validarDatos() {
        _valida.value = !(cantidad.value.isNullOrEmpty() || descripcion.value.isNullOrEmpty())
    }

    override fun showToast(message: String) {
        callback?.showToast(message)
    }


}