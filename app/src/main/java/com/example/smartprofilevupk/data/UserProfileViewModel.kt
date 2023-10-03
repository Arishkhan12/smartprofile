package com.example.smartprofilevupk.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserProfileViewModel(private val repository: UserProfileRepository) : ViewModel() {
    val allUserProfiles: LiveData<List<UserProfileEntity>> = repository.allUserProfiles

    fun insertUserProfile(userProfile: UserProfileEntity) = viewModelScope.launch {
        repository.insertUserProfile(userProfile)
    }
}
