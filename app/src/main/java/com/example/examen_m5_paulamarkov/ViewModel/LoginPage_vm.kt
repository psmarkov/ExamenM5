package com.example.examen_m5_paulamarkov.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


// para agregar un toast y mostarlo en la vista
interface ToastCallback {
    fun showToast(message: String)
}

class LoginPage_vm: ViewModel(), ToastCallback{


    // XML PASS E EMAIL y variable para validar ------------------------------------------
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    private val _pass = MutableLiveData<String>()
    val pass: LiveData<String> get() = _pass

    private val _valida = MutableLiveData<Boolean>()
    val valida: LiveData<Boolean> get() = _valida

    // para hacer llamadoa  toast
    var callback: ToastCallback? = null

    // -----------------------------------------------------------------------

    //Mecanica
    // recibe el valor del email y pass por parametro y lo guarda en la variable del ViewModel
    fun recibeDatos(email:String,pass:String) {
        _email.value = email
        _pass.value = pass

        // Valida los datos y pasa el mensaje al valor del email para que se pinte en el xml
        if (_email.getValue() == null || _email.getValue()!!.isEmpty()) {

            _email.value = "ENTER EMAIL ADDRESS."
            _valida.value = false

            return
        }

        if (_pass.getValue() == null || _pass.getValue()!!.isEmpty()) {
            _pass.value = "Enter Password"
            _valida.value = false
            return
        }

       // _valida.value = !(_email.value.isNullOrEmpty() ||  _pass.value.isNullOrEmpty())

        //Muestra un toast si los  datos se ingresaron bien
        showToast("Datos Válidos")
        _valida.value = true


    }
    override fun showToast(message: String) {
        callback?.showToast(message)
    }
}