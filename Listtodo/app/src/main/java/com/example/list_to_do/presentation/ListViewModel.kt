package com.example.list_to_do.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ListViewModel(): ViewModel() { // Estoy creando una clase llamada ListViewModel que es un tipo de ViewModel, Estoy HEREDANDO las cosas de ViewModel
    // ambas son clases y : es herencia
    private val _list = MutableStateFlow(listOf("barrer","cuidar a merli"))
    val list= _list.asStateFlow()

    private val _text = MutableStateFlow("")
    val text = _text.asStateFlow()

    fun Remove(index: Int){
        val currentList = _list.value.toMutableList()
        currentList.removeAt(index = index)
        _list.value= currentList

    }

    fun OnClickChanged(newText: String){
        _text.value= newText

    }

    fun Add(){
        if ( _text.value.isNotBlank()) {val currentList = _list.value.toMutableList()
            currentList.add(_text.value)
        _list.value= currentList
        _text.value =""}

    }

}