package com.example.examen_m5_paulamarkov.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// para agregar un toast y mostarlo en la vista


class SignupPage_vm : ViewModel(), ToastCallback{

    // XML datos para observar y variable para validar ------------------------------------------

    private val _nombre = MutableLiveData<String>()
    val nombre: LiveData<String> get() = _nombre

    private val _apellido = MutableLiveData<String>()
    val apellido: LiveData<String> get() = _apellido

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    private val _pass = MutableLiveData<String>()
    val pass: LiveData<String> get() = _pass

    private val _repass = MutableLiveData<String>()
    val repass: LiveData<String> get() = _repass

    private val _valida = MutableLiveData<Boolean>()
    val valida: LiveData<Boolean> get() = _valida

    // para hacer llamadoa  toast
    var callback: ToastCallback? = null

    // -----------------------------------------------------------------------

    fun recibeDatosSP(nombre:String,apellido:String,email:String,pass:String,repass:String) {
        _nombre.value = nombre
        _apellido.value = apellido
        _email.value = email
        _pass.value = pass
        _repass.value = repass
        _valida.value = true

        validarDatos()

        //Muestra un toast si los  datos se ingresaron bien
        showToast("Datos Válidos")

    }

    private fun validarDatos() {
        _valida.value = !(nombre.value.isNullOrEmpty() || apellido.value.isNullOrEmpty()||email.value.isNullOrEmpty()||pass.value.isNullOrEmpty()||repass.value.isNullOrEmpty())
    }

    override fun showToast(message: String) {
        callback?.showToast(message)
    }
}