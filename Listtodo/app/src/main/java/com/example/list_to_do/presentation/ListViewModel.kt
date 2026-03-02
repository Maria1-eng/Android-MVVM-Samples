package com.example.list_to_do.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class ListViewModel(): ViewModel() { // Estoy creando una clase llamada ListViewModel que es un tipo de ViewModel, Estoy HEREDANDO las cosas de ViewModel
    // ambas son clases y : es herencia
    private val _list = MutableStateFlow(listOf(ListModel("barrer"),
        ListModel("cuidar a merli"),
        ListModel("limpiar cocina"), ListModel(" tirar basura")))
    val list= _list.asStateFlow()

    private val _text = MutableStateFlow("")
    val text = _text.asStateFlow()

    private val _enabled = MutableStateFlow(false)
    val enabled = _enabled.asStateFlow()


    fun Remove(index: Int){
        val currentList = _list.value.toMutableList()
        currentList.removeAt(index = index)
        _list.value= currentList

    }

    fun OnClickChanged(newText: String){
        _text.value= newText

    }

    fun Add(){
        if ( _text.value.isNotBlank()) {
            val currentList = _list.value.toMutableList()
            currentList.add(ListModel(name=text.value, checked = false))
        _list.value= currentList
        _text.value =""}

    }
    fun onCheckBox(index: Int){
        val currentList = _list.value.toMutableList()
        val item = currentList[index]
        currentList[index] = item.copy(
            checked = !item.checked
        )
        _list.value = currentList

    }}