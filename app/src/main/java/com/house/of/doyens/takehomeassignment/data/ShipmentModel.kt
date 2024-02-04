package com.house.of.doyens.takehomeassignment.data

data class ShipmentModel (
    val status : String? = null,
    val statusUpdate : String? = null,
    val statusDescription : String? = null,
    var shipmentAmount : String? = null,
    var shipmentDate : String? = null
)