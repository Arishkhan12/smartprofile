package com.example.smartprofilevupk.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smartprofilevupk.R


class UserProfileAdapter : RecyclerView.Adapter<UserProfileAdapter.UserProfileViewHolder>() {

    private var userProfiles = emptyList<UserProfileEntity>()

    class UserProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val usernameTextView: TextView = itemView.findViewById(R.id.usernameTextView)
        val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserProfileViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_profile_item, parent, false)
        return UserProfileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserProfileViewHolder, position: Int) {
        val currentUserProfile = userProfiles[position]
        holder.usernameTextView.text = "Username: ${currentUserProfile.username}"
        holder.emailTextView.text = "Email: ${currentUserProfile.email}"
    }

    override fun getItemCount(): Int {
        return userProfiles.size
    }

    fun setUserProfiles(userProfiles: List<UserProfileEntity>) {
        this.userProfiles = userProfiles
        notifyDataSetChanged()
    }
}
