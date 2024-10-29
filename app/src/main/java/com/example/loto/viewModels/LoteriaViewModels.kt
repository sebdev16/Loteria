package com.example.loto.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class LoteriaViewModels:ViewModel() {
    private val _lotoNumbers = mutableStateOf(emptyList<Int>())
    val lotoNumbers: State<List<Int>> = _lotoNumbers

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun generateLotoNumbers()
    {
        _isLoading.value = true // Activa el estado de carga

        viewModelScope.launch {
            delay(1000) // Simula un tiempo de espera para la generación
            val numbers = (1..49).shuffled().take(6).sorted() // Genera números de lotería
            _lotoNumbers.value = numbers

            _isLoading.value = false // Desactiva el estado de carga
        }

    }

}