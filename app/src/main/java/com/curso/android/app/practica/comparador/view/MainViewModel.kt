package com.curso.android.app.practica.comparador.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.comparador.model.Comparador
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val comparador: LiveData<Comparador> get() = _comparador
    private var _comparador = MutableLiveData<Comparador>(Comparador("", "", ""))


    fun compare(text1 : String, text2 : String) {
        var res = ""
        if (text1 == text2) {
            res = "Son iguales"
        } else {
            res = "Son distintos"
        }
        updateResult(res);
    }


    private fun updateResult(result : String) {
        viewModelScope.launch {
            _comparador.value = Comparador(_comparador.value?.text1 ?: "", _comparador.value?.text2 ?: "", result)
        }
    }





}