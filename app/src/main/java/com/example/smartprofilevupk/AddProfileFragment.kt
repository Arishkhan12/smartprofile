package com.example.smartprofilevupk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.smartprofilevupk.data.UserProfileEntity
import com.example.smartprofilevupk.data.UserProfileViewModel

class AddProfileFragment : Fragment() {

    private lateinit var userProfileViewModel: UserProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_profile, container, false)

        val usernameEditText = view.findViewById<EditText>(R.id.editTextUsername)
        val emailEditText = view.findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = view.findViewById<EditText>(R.id.editTextPassword)
        val saveButton = view.findViewById<Button>(R.id.btnSave)

        userProfileViewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)

        saveButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                val userProfile = UserProfileEntity(username = username, email = email, password = password)
                userProfileViewModel.insertUserProfile(userProfile)
                Toast.makeText(requireContext(), "Profile added successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
