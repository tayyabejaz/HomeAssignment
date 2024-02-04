package com.house.of.doyens.takehomeassignment.ui.shipment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShipmentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Shipment Fragment"
    }
    val text: LiveData<String> = _text
}