package com.example.smartprofilevupk.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserProfileDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserProfile(userProfile: UserProfileEntity)

    @Query("SELECT * FROM user_profiles")
    fun getAllUserProfiles(): LiveData<List<UserProfileEntity>>
}
