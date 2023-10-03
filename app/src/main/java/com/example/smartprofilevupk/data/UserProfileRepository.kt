package com.example.smartprofilevupk.data

import androidx.lifecycle.LiveData

class UserProfileRepository(private val userProfileDAO: UserProfileDAO) {
    val allUserProfiles: LiveData<List<UserProfileEntity>> = userProfileDAO.getAllUserProfiles()

    suspend fun insertUserProfile(userProfile: UserProfileEntity) {
        userProfileDAO.insertUserProfile(userProfile)
    }
}
