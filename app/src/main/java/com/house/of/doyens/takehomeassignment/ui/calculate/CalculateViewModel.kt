package com.house.of.doyens.takehomeassignment.ui.calculate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculateViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This screen will have more awesome feature in the next update"
    }
    val text: LiveData<String> = _text
}