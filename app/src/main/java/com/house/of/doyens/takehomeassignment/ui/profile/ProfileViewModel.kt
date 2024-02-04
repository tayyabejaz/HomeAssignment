package com.house.of.doyens.takehomeassignment.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.house.of.doyens.takehomeassignment.UserProfile

class ProfileViewModel : ViewModel() {

    private val user = MutableLiveData<UserProfile>().apply {
        UserProfile(
            userName = "Tayyab Ejaz",
            userDesignation = "Principal Android Engineer",
            profilePhoto = ""
        )
    }
    val userdata: LiveData<UserProfile> = user

}