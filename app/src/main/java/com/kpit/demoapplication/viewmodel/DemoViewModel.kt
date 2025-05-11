package com.kpit.demoapplication.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DemoViewModel : ViewModel() {

    private val _text = MutableStateFlow("")
    val text: StateFlow<String> = _text

    private val _selected = MutableStateFlow("")
    val selected: StateFlow<String> = _selected

    fun onTextChanged(newText: String) {
        _text.value = newText
    }

    fun onSelectionChanged(newSelection: String) {
        _selected.value = newSelection
    }
}
